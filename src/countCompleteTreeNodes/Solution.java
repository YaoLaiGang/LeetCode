package countCompleteTreeNodes;

public class Solution {
    /*
    * 给一个完全二叉树，求出其节点个数
    * 最简单的方法就是递归法，“递归在手，天下我有”，无论什么树递归就完事了
    * */
    public int countNodes(TreeNode root) {
        return root==null? 0 : countNodes(root.left)+countNodes(root.right)+1;
    }
}
