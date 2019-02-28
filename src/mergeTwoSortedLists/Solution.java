package mergeTwoSortedLists;


public class Solution {
/**
 * 简单题目，就是将两个排好序的链表合并，合并后也要有序
 * */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1),p1,p1end,p2,ptmp;
		head.next = l1;
		p1end=head;
		p1=l1;
		p2=l2;
		while(p2!=null){
			while(p1!=null&&p2.val>p1.val) {
				p1end=p1;
				p1=p1.next;
			}
			//插入p2
			ptmp=p2;
			p2=p2.next;
			ptmp.next=p1;
			p1end.next=ptmp;
			p1end = p1end.next;
		}
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x1 = {1}, x2 = {2};
		ListNode l1 = new ListNode(x1), l2 = new ListNode(x2),l3;
		l3 = mergeTwoLists(l1, l2);
		while (l3!=null) {
			System.out.println(l3.val);
			l3=l3.next;
		}
	}

}
