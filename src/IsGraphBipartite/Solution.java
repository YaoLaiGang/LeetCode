package IsGraphBipartite;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    * 判断一个图是不是二部图，二部图就是可以把一个图中的点换分成两个集合，这两个集合内的点都不互相连接，
    * 只有两个集合之间的点可以互相连接。
    * 这个问题的解法是“染色法”，遍历图，给每个节点染色，并且相邻节点的颜色不同，如果颜色相同，
    * 则说明不是二部图。
    * DFS BFS均可
    * */
// 这里首先采用BFS法
    private int[] color;// 0表示未访问, 填1和-1两种颜色
    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        this.graph = graph;
        for (int i = 0; i < graph.length; i++) {
            if (color[i]!=0) continue;
            else {
                if (!bfs(i)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;
        while (!q.isEmpty()){
            int node = q.poll(), c = color[node];
            for (int nei :
                    graph[node]) {
                if (color[nei]==0) {
                    color[nei] = -c;
                    q.offer(nei);
                }
                else if (color[nei]!=-c) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {{1,2,3},{0,3,2},{0,1,3},{0,1,2}};
        System.out.println(solution.isBipartite(graph));
    }
}
