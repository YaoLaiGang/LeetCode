package flattenBinaryTreetoLinkedList;

public class Solution {
    /*
    * 将一个二叉树flatten成一条链表，链表的顺序就是二叉树前序遍历的顺序
    *
    * 思路肯定是要走先序遍历的，但是需要有一个pre节点保存其先序遍历的上一个节点
    * 并且其右孩子因为子树的遍历会产生改变，也应该保存
    * */
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root==null) return;
        preOrder(root);
    }
    private void preOrder(TreeNode root){
        if (root==null) return;
        TreeNode left = root.left, right = root.right;
        if(pre!=null) {
            // 根据先序顺序，pre的右孩子肯定是root节点
            pre.right = root;
        }
        pre = root;
        preOrder(left);
        preOrder(right);
        // 不要忘了左子树最后是空的
        root.left = null;
    }
}
