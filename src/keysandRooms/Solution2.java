package keysandRooms;

import java.util.List;

public class Solution2 {
    /*
    * 使用DFS,其速度比DFS快
    * */
    int n = 0;
    boolean[] visited;
    List<List<Integer>> rooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        visited = new boolean[rooms.size()];
        this.rooms = rooms;
        dfs(0);
        return n==rooms.size();
    }
    public void dfs(int root){
        visited[root] = true;
        ++n;
        for (Integer nei :
                rooms.get(root)) {
            if (!visited[nei]) dfs(nei);
        }
    }
}
