package binaryTreePreorderTraversal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
    * 二叉树先序遍历，这个问题不难，递归非递归都可以
    * */
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }
    private void preOrder(TreeNode root){
        if (root==null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void preOrder2(TreeNode root){
        // 非递归
        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();
        while (p!=null||!s.isEmpty()){
            while (p!=null){
                res.add(p.val);
                s.push(p);
                p = p.left;
            }
            p = s.pop().right;
        }
    }
}
