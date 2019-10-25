package convertSortedArraytoBinarySearchTree;

public class Solution {
    /*
    * 给一个排好序的数组，然后通过排好序的数组构建二叉搜索树
    * 要求二插搜索树是平衡的，也就是说任何一个节点的左右子树的高度差不能超过1
    *
    * 思路就是递归
    * 每次递归做如下的事情：
    * 找到中点作为根
    * 中点左/右边作为其左/右子树，递归
    * */
    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        this.nums = nums;
        return createBST(0, nums.length-1);
    }
    private TreeNode createBST(int left, int right){
        if (left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(left, mid-1);
        root.right = createBST(mid+1, right);
        return root;
    }
}
