package populatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//    这里的Node加了右兄弟指针next,本算法就是要把二叉树的next指针填上
//    具体思路是使用层序遍历
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node tmp;
        while (!queue.isEmpty()){
            int len = queue.size();
            Node pre = queue.poll();
            if (pre.left!=null) queue.offer(pre.left);
            if (pre.right!=null) queue.offer(pre.right);
            for (int i = len-1; i>0; --i){
                tmp = queue.poll();
                pre.next = tmp;
                pre = tmp;
                if (tmp.left!=null) queue.offer(tmp.left);
                if (tmp.right!=null) queue.offer(tmp.right);
            }
        }
        return root;
    }
}
