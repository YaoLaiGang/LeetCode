package networkDelayTime;

import java.util.*;

public class Solution {
    /*
    * 这个问题是以计网为背景的一个问题，在局域网中的一个点要把信息广播到所有节点需要多长时间
    * 这类问题显然是单源最短路径问题，只要求得所有最短路径中的最大值即可
    * 常用的经典算法有Dijkstra(贪心法) Bellman-Ford(动态规划) 当然 Floyd这种多源最短路径也可以实现。
    * */
    public int networkDelayTime(int[][] times, int N, int K) {
        K--;
        int[][] graph = new int[N][N];
        boolean[] visited = new boolean[N];
        Node[] dist = new Node[N];
        int n = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = i==j ? 0 : Integer.MAX_VALUE;//-1 表示不可达
            }
        }
        for (int[] edge :
                times) {
            graph[edge[0] - 1][edge[1] - 1] = edge[2];
        }
        for (int i = 0; i < N; i++) {
            dist[i] = i==K ? new Node(i, 0) : new Node(i, Integer.MAX_VALUE);
        }
        Node min = dist[K];
        while (n!=0&&min.weight!=Integer.MAX_VALUE){
            visited[min.val] = true;
            --n;
            for (int i = 0; i < N; i++) {
                if (visited[i]||i==min.val) continue;
                if (graph[min.val][i]==Integer.MAX_VALUE) continue;
                if (min.weight+graph[min.val][i]<dist[i].weight){
                    dist[i].weight = min.weight+graph[min.val][i];
                }
            }
            min = null;
            for (int i=0; i<N; i++){
                if (visited[i]) continue;
                else if (min==null) min = dist[i];
                else {
                    min = min.weight < dist[i].weight ? min : dist[i];
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        if (n==0) return Collections.max(Arrays.asList(dist)).weight;
        return -1;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,1},{2,1,3}};
        System.out.println((new Solution()).networkDelayTime(input, 2, 2));
    }
}
class Node implements Comparable<Node>{
    // val 表示 K->val weight表示其权重
    int val;
    int weight;
    public Node(int val, int weight){
        this.val = val;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }
    public String toString(){
        return val+":"+weight;
    }
}