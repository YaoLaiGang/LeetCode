package linkedListCycle;

public class Solution {
    /*
    * 判断链表中是否有环， 这个问题使用快慢指针即可
    * 不仅如此，使用快慢指针还可以判定环的起点：
    * 1. 让快指针和慢指针同时从起点出发，直到相遇
    * 2. 让一个指针从起点出发，另一个从相遇点出发，两者相遇的点就是环的起始点
    * */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null){
            slow = slow.next;
            if (fast.next==null) return false;
            fast = fast.next.next;
            if (slow==fast) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}
