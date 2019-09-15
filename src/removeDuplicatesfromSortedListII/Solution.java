package removeDuplicatesfromSortedListII;

public class Solution {
/**
 * 从排好序的链表中删除重复元素，注意这里的删除是全部删除，不是删除到不重复
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 这里应该使用两个指针p,q,q在p的前面，p检测到重复就一次向前直到重复的最后一个元素，然后q、p连接
 * 为防止开头节点，可以加个头结点
 * */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
        ListNode p = head,q;
        head = new ListNode(-1);
        head.next = p;
        q = head;
        while (p!=null) {
			while (p.next!=null&&p.val==p.next.val) {
				p=p.next;
			}
			if(q.next!=p) {
				//有重复，需要删除
				p = p.next;
				q.next = p;
			}else {//没重复，正常运行
				p = p.next;
				q = q.next;
			}
		}
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,1,2};
		ListNode list = new ListNode(input);
		Solution solution = new Solution();
		list = solution.deleteDuplicates(list);
		while (list!=null) {
			System.out.println(list.val);
			list = list.next;
		}
	}

}
