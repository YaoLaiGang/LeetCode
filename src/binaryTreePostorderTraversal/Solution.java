package binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
    * 二叉树后序遍历，这个问题递归很简单，非递归很难
    * */
    private List<Integer> res = new ArrayList<>();
    private LinkedList<Integer> res2 = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }
    private void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }
    private void postOrder2(TreeNode root){
//        非递归写法，将 左右根转化为根右左(转化之后和先序的递归遍历类似，只不过是向右走了)
        TreeNode p = root;
        Stack<TreeNode> s = new Stack<>();
        while (p!=null||!s.isEmpty()){
            while (p!=null){
                s.push(p);
                res2.offerFirst(p.val);
                p = p.right;
            }
            p = s.pop().left;
        }
    }
}
