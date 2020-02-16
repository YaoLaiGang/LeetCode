package redundantConnection;

import java.util.*;

public class Solution {
    /*
    * 本题是给了一个带环的无向图（在原来不带换的基础上加了一条边使其成为环）
    * 要求你给出一条边，使得删除这条边以后整个图变成无环图、
    * 如果有多个解，给出输入中所有符合要求的边的最后一个
    * 思路：
    * 要删除的边的两点肯定是环中的两点，因此我的思路是
    * 1.先使用DFS或者拓扑排序（注意这里无向图不是度为0，而是度<=1）, 求出环中的点
    * 2. 在输入中逆向遍历，找到两点均为环中点的边，删除之
    * */
    private HashMap<Integer, List<Integer>> graph;
    private int[] visited;
    public int[] findRedundantConnection(int[][] edges) {
        graph = new HashMap<>();
        for (int[] edge :
                edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new int[graph.size()+1];//从1开始
        HashSet<Integer> cycle = dfs(1,new ArrayList<>(), 1);
        for (int i = edges.length-1; i >= 0; i--) {
            if (cycle.contains(edges[i][0])&&cycle.contains(edges[i][1])) return edges[i];
        }
        return null;
    }
    private HashSet<Integer> dfs(int node, ArrayList<Integer> path, int pre){
        /*
        * 寻找图的环上的节点
        * */
        visited[node] = 1;
        path.add(node);
        HashSet<Integer> res = null, tmp;
        for (int next :
                graph.get(node)) {
            if (visited[next]==2) continue;
            if (next!=pre&&visited[next]==1) {// 不是父节点且访问到了访问过的节点，存在环
                ArrayList<Integer> cycle =new ArrayList<Integer>(path.subList(path.indexOf(next),path.size()));
                System.out.println(cycle);
                visited[node]=2;
                path.remove((Integer)node);
                return new HashSet<>(cycle);
            }else if(visited[next]==0){
                tmp = dfs(next, path, node);
                res = tmp==null ? res : tmp;
            }
        }
        path.remove((Integer)node);
        visited[node] = 2;
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString((new Solution()).findRedundantConnection(input)));
    }
}
