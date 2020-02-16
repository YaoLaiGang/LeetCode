package redundantConnection;

import java.util.*;

public class Solution2 {
    /*
    * 使用拓扑排序来解这个问题
    * 这里是无向边，只要度<=1即可
    *
    * 这种方法虽然可以解决这个问题，但是速度太慢，未通过
    * */
    private HashMap<Integer, List<Integer>> graph;
    private HashMap<Integer, Integer> degree;
    private HashSet<Integer> find;
    public int[] findRedundantConnection(int[][] edges) {
        // 构造图结构和计算点的度
        graph = new HashMap<>();
        degree = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int[] edge :
                edges) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
                degree.put(edge[0], 0);
            }
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
                degree.put(edge[1], 0);
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree.put(edge[0], degree.get(edge[0])+1);
            degree.put(edge[1], degree.get(edge[1])+1);
            if (degree.get(edge[0])<=1){
                q.offer(edge[0]);
            }else if (q.contains(edge[0])){
                q.remove((Integer)edge[0]);
            }
            if (degree.get(edge[1])<=1){
                q.offer(edge[1]);
            }else if (q.contains(edge[1])){
                q.remove((Integer)edge[1]);
            }
        }
        find = new HashSet<>(graph.keySet());
        // 拓扑排序
        while (!q.isEmpty()){
            int node;
            for (int i = q.size(); i > 0; i--) {
                node = q.poll();
                find.remove((Integer)node);
                for (int next :
                        graph.get(node)) {
                    int d = degree.get(next)-1;
                    degree.put(next, d);
                    if (d<=1) q.offer(next);
                }
            }
        }
        for (int i = edges.length-1; i >= 0; i--) {
            if (find.contains(edges[i][0])&&find.contains(edges[i][1])) return edges[i];
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] input = {{1,2},{1,3},{2,3}};//{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString((new Solution2()).findRedundantConnection(input)));
    }
}
