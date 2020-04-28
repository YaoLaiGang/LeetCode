package reorderList;

public class Solution2 {
    /*
    * 这里使用方法二，纯链表操作而不借助数组
    *
    * */
    public void reorderList(ListNode head) {
        // 1. 利用快慢指针找到中点
        if (head==null || head.next==null || head.next.next==null) return;;
        ListNode slow = head, fast = head, p, tmp;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2. 断链，B就地逆置
        fast = slow.next;
        slow.next = null;
        p = fast.next;
        fast.next = null;
        while (p!=null){
            tmp = fast;
            fast = p;
            p = p.next;
            fast.next = tmp;
        }
        // 3. 插入
        p = head;
        while (fast!=null){
            tmp = fast;
            fast = fast.next;
            tmp.next = p.next;
            p.next = tmp;
            p = p.next.next;
        }
    }
}
