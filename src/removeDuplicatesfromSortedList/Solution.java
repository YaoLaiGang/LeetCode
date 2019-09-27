package removeDuplicatesfromSortedList;

import removeDuplicatesfromSortedList.ListNode;

/**
 * 上一题(https://github.com/YaoLaiGang/LeetCode/blob/master/src/removeDuplicatesfromSortedListII/Solution.java)的简单版
 * 这里的重复元素不要求全部删除，只保留一个即可，思路基本相同，不过这里只需要一个指针P即可
 * */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		ListNode p = head;
		while (p.next!=null) {
			if (p.val==p.next.val) {
				p.next = p.next.next;
			}else {
				p = p.next;
			}
		}
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,1};
		ListNode list = new ListNode(input);
		Solution solution = new Solution();
		list = solution.deleteDuplicates(list);
		while (list!=null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

}
