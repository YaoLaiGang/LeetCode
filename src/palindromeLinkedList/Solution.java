package palindromeLinkedList;

public class Solution {
    /*
    * 判断一个链表是否为回文链表，最简单的方法就是用栈和快慢指针搭配
    * 不过这种方法的空间复杂度达到了O(n)
    * 因此我们使用快慢指针+就地逆置，使得链表的前半部分逆置。这样可同时遍历前后两个链表来判断是否回文
    * */
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        ListNode fast = head, slow = head, h = new ListNode(-1,head), preSlow=h, q;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            // 逆置并步进
            q = slow.next;
            slow.next = preSlow;
            preSlow = slow;
            slow = q;
        }
        if (fast.next==null){// 奇数链表，slow就是中点
            q = slow.next;
        }else{// 偶数链表，slow在左侧
            q = slow.next;
            slow.next = preSlow;
            preSlow=slow;
        }
        while (q!=null){
            if (q.val!=preSlow.val) return false;
            q = q.next;
            preSlow = preSlow.next;
        }
        return true;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){this.val=val;this.next=next;}
}