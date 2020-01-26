package courseSchedule;

import java.util.ArrayList;

public class Solution2 {
    /*
    * 使用DFS来解决本问题
    * DFS思路很简单，只要访问某个点的时候，发现要访问的点已经被访问了，就说明存在了环,
    * 这里的visited有些特殊
    * 0 表示未访问
    * 1 表示正在访问
    * 2 表示访问完毕
    * 如果当前节点为1并且要访问的点也是1，那个这个图存在环
    * */
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites){
        Node[] graph = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Node(i, new ArrayList<>());
        }
        for (int[] pair :
                prerequisites) {
            graph[pair[1]].neighbors.add(graph[pair[0]]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]==0&&!dfs(graph[i]))  return false;
        }
        return true;
    }
    private boolean dfs(Node root){
        visited[root.val] = 1;
        for (Node n :
                root.neighbors) {
            if (visited[n.val]==2) continue;
            if (visited[n.val]==1) return false; // 存在环
            else {
                if (!dfs(n)) return false;
            }
        }
        visited[root.val]=2;
        return true;
    }

    public static void main(String[] args) {
        int[][] input = {{1,0},{0,1}};
        System.out.println((new Solution2()).canFinish(2, input));
    }
}
