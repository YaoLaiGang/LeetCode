package oddEvenLinkedList;

public class Solution {
    /*
    * 奇偶链表：将链表中奇数下标的元素放到链表前面，偶数下标的元素放到链表后面
    * 思路：穿糖葫芦法，维护两个链表（奇数链表和偶数链表），使用尾插法，逐个补全，最后把偶数链表插到奇数链表后即可
    * */
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode odd = head, oddRear = head, even = head.next, evenRear = head.next, p = head.next.next;
        int i = 1;
        while (p!=null){
            if (i % 2 != 0) {//奇数
                oddRear.next = p;
                oddRear = p;
            }else {
                evenRear.next = p;
                evenRear = p;
            }
            ++i;
            p=p.next;
        }
        oddRear.next = even;
        evenRear.next = null;
        return odd;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}