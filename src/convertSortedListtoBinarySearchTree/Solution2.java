package convertSortedListtoBinarySearchTree;

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        /*
         *通过快慢指针来查找链表的中值，然后构造根、左、右
         *  */
        return createBST(head, null);//这里的right是右界，right的上一个节点可以用，right是一个哨兵
    }
    private TreeNode createBST(ListNode left, ListNode right){
        if (left==right) return null;
        ListNode slow = left;
        ListNode fast = left;
        while (fast!=right&&fast.next!=right){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = createBST(left, slow);
        root.right = createBST(slow.next, right);
        return root;
    }
}
