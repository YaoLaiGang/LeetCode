package maximumDepthofBinaryTree;

public class Solution {
    //求树的最大深度，这个遍历即可
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return preOrder(root, 1);
    }
    private int preOrder(TreeNode root, int depth){
        if (root==null) return depth-1;
        return Math.max(preOrder(root.left, depth+1), preOrder(root.right, depth+1));
    }
}
