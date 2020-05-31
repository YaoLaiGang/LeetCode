package removeLinkedListElements;

public class Solution {
    /*
    * 这问题没啥好说的，链表基本操作CRUD之一
    * */
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        ListNode h = new ListNode(-1, head), pre = h, p = head;
        while (p!=null){
            if (p.val==val){
                pre.next = p.next;
//                p.next = null;
                p = pre.next;
            }else {
                pre = pre.next;
                p = p.next;
            }
        }
        return h.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){this.val=val;this.next=next;}
}