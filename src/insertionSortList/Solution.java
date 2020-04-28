package insertionSortList;

public class Solution {
    /*
    * 对链表进行插入排序, 插入排序在数组中肯定不复杂，对于链表需要一些特殊的操作
    * 这里可以在插入的时候进行优化，比如可以设置一个尾指针，先判定是否大于尾指针，可以省去遍历的时间
    * */
    public ListNode insertionSortList(ListNode head) {
        if (head==null) return null;
        ListNode p = head.next, q, r, end=head;
        head.next = null;
        while (p!=null){
            q = p;
            p = p.next;
            r = head;
            // 能够插入的位置除了中间，还有最开头和最结尾
            if (q.val<=head.val){
                q.next = head;
                head = q;
                continue;
            }
            if (q.val>=end.val){
                end.next = q;
                end = q;
                end.next = null;
                continue;
            }
            while (r.next!=null){
                if (r.val<=q.val&&r.next.val>=q.val){
                    q.next = r.next;
                    r.next = q;
                    break;
                }
                r = r.next;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
