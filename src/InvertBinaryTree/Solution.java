package InvertBinaryTree;

public class Solution {
    /*
    * 将二叉树的左右节点变换，这个题目太简单了
    * */
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
