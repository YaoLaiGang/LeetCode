package convertSortedListtoBinarySearchTree;

import java.util.ArrayList;

public class Solution {
    /*
    * 和上面通过Array转化为二叉搜索树类似，这里使用了排序链表来生成二叉搜索树
    * 链表难以立刻获取到中间值，这是个问题
    * 一种方法是先把链表转化成数组，然后再通过数组转化为二叉搜索树，这个方法比较简单
    * */
    private ArrayList<Integer> nums = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        /*
        * 将链表转化为数组，然后再通过Convert Sorted Array to Binary Search Tree的方法生成二插搜索树
        * 注： 这种方法的时间效率很低
        * */
        while (head!=null){
            nums.add(head.val);
            head = head.next;
        }
        return createBST(0, nums.size()-1);
    }
    private TreeNode createBST(int left, int right){
        if (left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = createBST(left, mid-1);
        root.right = createBST(mid+1, right);
        return root;
    }
}
