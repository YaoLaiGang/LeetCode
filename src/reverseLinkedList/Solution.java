package reverseLinkedList;

public class Solution {
/*
* 链表逆置问题，经典题将链表逆置，
* 法一：头插法逆置
* 法二：就地逆置
* */
    public ListNode reverseList(ListNode head) {
//        头插法逆置
        if (head==null) return null;
        ListNode top = new ListNode(-1), p=head;
        top.next = null;
        while (p!=null){
            head = p.next;
            p.next = top.next;
            top.next = p;
            p = head;
        }
        return top.next;
    }
    public ListNode reverseList2(ListNode head){
//        就地法逆置
        if (head==null) return null;
        ListNode p = head.next, q = head, r;
        while (p!=null){
            r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        head.next = null;
        return q;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        ListNode res = (new Solution()).reverseList2(new ListNode(input));
        while (res != null){
            System.out.println("res = " + res.val);
            res = res.next;
        }
    }
}
