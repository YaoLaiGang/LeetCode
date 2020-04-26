package linkedListCycleII;

public class Solution {
    /*
    * 链表中可能存在环，如果存在返回环开始的节点，否则返回null
    * 思路：使用快慢指针
    * 1. 先布置快慢指针，如果有环两者会相遇，否则没有环
    * 2. 在起点和相遇的地方放置两指针，两者同时运动，当两者相遇就是环开始的节点(可证明)
    * */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null){
            slow = slow.next;
            if (fast.next==null) return null;
            fast = fast.next.next;
            if (slow==fast) break;
        }
        if (fast==null) return null;
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }
}
