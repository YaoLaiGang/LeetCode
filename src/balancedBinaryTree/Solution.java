package balancedBinaryTree;

import java.util.HashMap;

public class Solution {
    /*
    * 判断一个树是不是平衡二叉树，其本质是求左右子树的高度
    * */
    private boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        getTreeHeight(root);
        return res;
    }
    private int getTreeHeight(TreeNode root){
        if (root==null) return 0;
        int a = getTreeHeight(root.left);
        int b = getTreeHeight(root.right);
        if (a-b>1||a-b<-1) res = false;
        return Math.max(a,b)+1;
    }
}
