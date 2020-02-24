package IsGraphBipartite;

public class Solution2 {
    private int[] color;// 0表示未访问, 填1和-1两种颜色
    private int[][] graph;
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        this.graph = graph;
        for (int i = 0; i < graph.length; i++) {
            if (color[i]!=0) continue;
            else {
                color[i] = 1;
                if (!dfs(i)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int start){
        int c = color[start];
        for (int nei :
                graph[start]) {
            if (color[nei]==0){
                color[nei] = -c;
                if (!dfs(nei)) return false;
            }
            else if (color[nei]==c) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(solution.isBipartite(graph));
    }
}
