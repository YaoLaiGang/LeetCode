package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    * 二叉树层序遍历,维护一个队列即可
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                t = queue.poll();
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
                tmp.add(t.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
