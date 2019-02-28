package swapNodesinPairs;

public class Solution {
/**
 * 给一个链表，互换相邻的两个节点
 * */	
	public static ListNode swapPairs(ListNode head) {
		ListNode top = new ListNode(-1);
		top.next=head;
		ListNode pre, end = top, mid = top.next, tmp;
		if(mid==null) return null;
		pre = mid.next;
		if(pre == null) return top.next;
		while(pre!=null){
			mid.next = pre.next;
			pre.next = mid;
			end.next = pre;
			tmp = mid;
			mid = pre;
			pre = tmp;
			pre = pre.next;
			if(pre==null) break;
			pre = pre.next;
			end = end.next.next;
			mid = mid.next.next;
		}
        return top.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		ListNode input = new ListNode(arr);
		ListNode ls = swapPairs(input);
		while(ls != null){
			System.out.println(ls.val);
			ls = ls.next;
		}
	}

}
