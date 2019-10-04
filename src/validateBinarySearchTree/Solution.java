package validateBinarySearchTree;

public class Solution {
    /*
    * 验证二叉搜索树，就是左子树所有元素小于根，右子树所有元素大于根的树
    * 注意到二叉搜索树的中序遍历一定满足递增，所以原问题简化为中序遍历是否递增的问题
    * */
    private int count = 0;
    private int pre;
    public boolean isValidBST(TreeNode root) {
        return inorderBT(root);
    }
    public boolean inorderBT(TreeNode root){
        if (root == null) return true;
        boolean left = inorderBT(root.left);
        if (count==0){
            ++count;
        }else {
            if (root.val<=pre) return false;
        }
        pre = root.val;
        boolean right = inorderBT(root.right);
        return left&&right;
    }
    public static void main(String[] args) {

    }
}
