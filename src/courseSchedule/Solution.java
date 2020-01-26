package courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* 你总共要选n门课，从0到n-1。
有些课程可能有先决条件，例如要选课程0，你必须先选课程1，课程1表示为一对:[0,1]
考虑到课程的总数和先决条件对的列表，你能完成所有的课程吗?
*
* 分析：本质问题是判断图是否有环，判断环的办法主要有DFS和BFS两种方案，本质上都是拓扑排序
* */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        计算所有点的入度, 构造图结构
        Queue<Node> queue = new LinkedList<>();
        Node[] graph = new Node[numCourses];
        int[] degree = new int[numCourses];
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
        if (queue.isEmpty()) return false;
        // 拓扑排序
        int count = 0; // 记录出队元素个数
        while (!queue.isEmpty()){
            Node node = queue.poll();
            ++count;
            for (Node n :
                    node.neighbors) {
                degree[n.val]--;
                if (degree[n.val]==0) queue.offer(n);
            }
        }
        if (count==numCourses) return true;
        return false;
    }
}
