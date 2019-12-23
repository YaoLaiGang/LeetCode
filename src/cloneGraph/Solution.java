package cloneGraph;

import java.util.*;

public class Solution {
    /*
    * 克隆一张图，实际上还是图的遍历问题
    * */
    private HashMap<Node, Node> visitedMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node cloneNode = new Node();
        cloneNode.neighbors = new ArrayList<>();
        cloneNode.val = node.val;
        visitedMap.put(node, cloneNode);
        for (Node n :
                node.neighbors) {
            if (!visitedMap.containsKey(n)){
                cloneNode.neighbors.add(cloneGraph(n));
            }else {
                cloneNode.neighbors.add(visitedMap.get(n));
            }
        }
        return cloneNode;
    }
    public static void main(String[] args) {
//        测试图的深度遍历和广度遍历
    }

    private ArrayList<Node> visited = new ArrayList<>(); // 当存在node时表示被访问，不存在表示没被访问
    public void dfs(Node node){
        /*
        * 深度优先，使用栈结构
        * */
        // 访问node
        System.out.println(node.val);
        visited.add(node);
        for (Node n :
                node.neighbors) {
            if (!visited.contains(n)) dfs(n);
        }
    }
    public void bfs(Node node){
//        广度优先遍历
        Queue<Node> queue = new LinkedList<>();
        List<Node> visited = new ArrayList<>();
        queue.offer(node);
        visited.add(node);
        Node iter;
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--) {
                iter = queue.poll();
                System.out.println(iter.val);
                for (Node n :
                        iter.neighbors) {
                    if (!visited.contains(n)) {
                        queue.offer(n);
                        visited.add(n);
                    }
                }
            }
        }
    }
}
