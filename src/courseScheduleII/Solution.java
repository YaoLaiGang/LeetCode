package courseScheduleII;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    * 同一，这里的区别就是如果能将课程修完就返回修课顺序，只需要一个即可
    * 如果不能修完返回空
    * 思路依然是使用BFS或者DFS，只不过要记录路径
    * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        * 使用BFS来解决该问题
        * */
        //        计算所有点的入度, 构造图结构
        Queue<Node> queue = new LinkedList<>();
        Node[] graph = new Node[numCourses];
        int[] degree = new int[numCourses];
        int[] res=new int[numCourses];
        int j=0;
        // 图初始化
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new Node(i, new ArrayList<>());
        }
        // 增加边关系，记录入度
        for (int[] pair :
                prerequisites) {
            graph[pair[1]].neighbors.add(graph[pair[0]]);
            degree[pair[0]]++;
        }
        // 入度为0进栈
        for (int i = 0; i < numCourses; i++) {
            if (degree[i]==0) queue.offer(graph[i]); // 入度为0加入队列
        }
        if (queue.isEmpty()) return new int[0];
        // 拓扑排序
        int count = 0; // 记录出队元素个数
        while (!queue.isEmpty()){
            Node node = queue.poll();
            res[j++]=node.val;
            ++count;
            for (Node n :
                    node.neighbors) {
                degree[n.val]--;
                if (degree[n.val]==0) queue.offer(n);
            }
        }
        if (count==numCourses) return res;
        return new int[0];
    }
}
