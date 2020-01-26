package findEventualSafeStates;

import java.util.*;

public class Solution {
    /*
    * 发现最终状态
    * 最终状态是指在一个有向图中出度为0的点，找到最终态的点和能够到达最终态的点。
    * 思路：该问题是拓扑排序的逆问题，反向拓扑排序
    * 维护一个出度表
    * */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] degree = new int[graph.length]; // 出度表，维护每个节点的出度
        ArrayList<ArrayList<Integer>> neighbor = new ArrayList<ArrayList<Integer>>();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < graph.length; i++) { // 初始化
            neighbor.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            //  从 i -> j, 转化成由j -> i
            for (int j = 0; j < graph[i].length; j++) {
                neighbor.get(graph[i][j]).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) { // 记录出度
            degree[i] = graph[i].length;
            if (degree[i]==0) {
                queue.offer(i);
                res.add(i);
            }
        }
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int n :
                    neighbor.get(node)) {
                degree[n]--;
                if (degree[n]==0) {
                    queue.offer(n);
                    res.add(n);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
