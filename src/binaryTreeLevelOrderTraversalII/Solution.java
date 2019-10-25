package binaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    * 层序遍历二叉树改进版，这次要求结果是从最后一层开始到第一层这样子
    * 其实完全可以按照普通的层序遍历最后在逆置一下即可
    * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();//每次从开头插入即可
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tmp;
        TreeNode t;
        while (!queue.isEmpty()){
            tmp = new ArrayList<>();
            for (int i = queue.size(); i>0; --i) {
                t = queue.poll();
                tmp.add(t.val);
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
            }
            res.addFirst(tmp);
        }
        return res;
    }
}
