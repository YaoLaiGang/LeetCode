package networkDelayTime;

import java.util.*;

public class Solution2 {
    /*
    * 解法一慈采用了Dijkstra的贪心策略，以点为基础不断扩展到达某个点的最短距离
    * 解法二我们使用Bellman的DP策略，以边为思路进行松弛操作
    * */
    public int networkDelayTime(int[][] times, int N, int K){
        --K;
        LinkNode[] graph = new LinkNode[N];
        Integer[] dist = new Integer[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new LinkNode();
        }
        for (int[] edge :
                times) {
            graph[edge[0]-1].neighbor.put(edge[1]-1, edge[2]);
        }
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[K] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        // Bellman -> SPFA
        while (!q.isEmpty()){
            for (int i = q.size(); i > 0 ; i--) {
                int from = q.poll();
                for (Map.Entry<Integer, Integer> edge :
                        graph[from].neighbor.entrySet()) {
                    int to = edge.getKey(), weight = edge.getValue();
                    if (dist[to]>dist[from]+weight){
                        dist[to] = dist[from]+weight;
                        if (!q.contains(to)) q.offer(to);
                    }
                }
            }
        }
        int res = Collections.max(Arrays.asList(dist));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] input = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println((new Solution2()).networkDelayTime(input, 4, 2));
    }
}
class LinkNode{
    HashMap<Integer, Integer> neighbor;
    public LinkNode(){
        neighbor = new HashMap<>();
    }
}
