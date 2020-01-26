package courseScheduleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Solution2 {
    /*
    * 使用DFS来记录拓扑排序
    * 0 表示未被访问
    * 1 表示正在访问，其子节点还未访问完毕
    * 2 表示访问完毕
    * */
    private Stack<Integer> stack = new Stack<>();
    private int[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        Node[] graph = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Node(i, new ArrayList<>());
        }
        for (int[] pair :
                prerequisites) {
            graph[pair[1]].neighbors.add(graph[pair[0]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]==0&&!dfs(graph[i])) return new int[0];
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }
    private boolean dfs(Node root){
        visited[root.val] = 1;
        for (Node n :
                root.neighbors) {
            if (visited[n.val]==2) continue;
            if (visited[n.val] == 1) return false;
            else if (!dfs(n)) return false;
        }
        stack.push(root.val);
        visited[root.val] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] input = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString((new Solution2()).findOrder(4, input)));
    }
}
