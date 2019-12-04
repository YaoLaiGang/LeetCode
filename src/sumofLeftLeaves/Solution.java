package sumofLeftLeaves;

public class Solution {
    /*
    * 求所有左叶子节点的和，必须是左叶子，使用遍历，并在参数中设置左右标记
    * */
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        preOrder(root, false);
        return sum;
    }
    private void preOrder(TreeNode root, boolean isLeft){
        if (root==null) return;
        if (root.left==null&&root.right==null){//叶子节点
            if (isLeft) sum+=root.val;
            return;
        }
        preOrder(root.left, true);
        preOrder(root.right, false);
    }
}
