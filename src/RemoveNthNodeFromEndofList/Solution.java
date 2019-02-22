package RemoveNthNodeFromEndofList;

public class Solution {
//	删除链表倒数第n个元素，用两个指针遍历即可（差N）
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next==null) return null;
		ListNode first = head, second, end=null;
		int count=0;
		while(first!=null&&count<n-1){
			first = first.next;
			count++;
		}
		second = head;
		// 同时前进，直到first 到末尾
		while(first.next!=null){
			end = second;
			second = second.next;
			first = first.next;
		}
		//删除second
		if (second.next==null) {// second是最后一个元素
			end.next = null;
			return head;
		}
		if (end == null) { // second 是第一个元素
			return head.next;
		}
		end.next = second.next;
		second.val = -1; // java 不需要析构函数
		return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ListNode ls = new ListNode(nums), iter ;
		ls = removeNthFromEnd(ls, 1);
		iter = ls;
		while(iter!=null){
			System.out.println(iter.val);
			iter = iter.next;
		}
	}

}
