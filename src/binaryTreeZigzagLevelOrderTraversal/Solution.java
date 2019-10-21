package binaryTreeZigzagLevelOrderTraversal;

import java.util.*;

public class Solution {
    /*
    * 二叉树Z字形遍历
    * 和层序遍历类似，不过这里第一层是left->right 第二层是right->left以此类推，最简单的做法就是逆置
    * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        TreeNode t;
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                t = queue.poll();
                tmp.add(t.val);
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
            }
            if (level%2==1) Collections.reverse(tmp);
            ++level;
            res.add(tmp);
        }
        return  res;
    }
}
