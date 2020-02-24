package keysandRooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    * 这个提说的是给一个数组rooms[i][j],表示你在第i个房间，拥有room[i]把钥匙进入下一个房间
    * 现在假设你在房间0，问能否遍历所有的房间。
    * 这道题是典型的遍历问题使用DFS或者BFS都可以，由于题目认为房间可以向前也可以向后，说明这是个无向图
    * */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int n = 1;
        while (!q.isEmpty()){
            for (int i = q.size(); i > 0; i--) {
                int v = q.poll();
                for (Integer nei :
                        rooms.get(v)) {
                    if (!visited[nei]) {
                        q.offer(nei);
                        visited[nei] = true;
                        ++n;
                    }
                }
            }
        }
        return n == rooms.size();
    }
}
