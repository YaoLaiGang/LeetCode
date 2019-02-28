package mergeKSortedLists;

public class Solution {
/**
 * 合并N个排序好的链表（之前是两个），要求结果有序
 * */
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length==0) return null;
		
		ListNode head = lists[0];
		for(int i=1; i<lists.length; ++i){
			head = mergeTwoLists(head, lists[i]);
		}
        return head;
    }
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
	public static ListNode mergeKLists2(ListNode[] lists) {
		/**
		 * 方法二
		 * 三个指针齐头并进，选出最小的插入
		 * */
		
		if (lists.length==0) return null;
		int n = lists.length, mini=0, minval= Integer.MAX_VALUE;
		for (ListNode listNode : lists) {
			n= listNode==null? --n: n;
		}
		ListNode head= new ListNode(-1),r = head;
		while(n!=0){
			minval= Integer.MAX_VALUE;
			mini=0;
			for(int i=0; i< lists.length; ++i){
				if (lists[i]==null) continue;
				if(minval>=lists[i].val){ 
					minval = lists[i].val;
					mini = i;
				}
			}
			if(lists[mini].next==null) --n;
			r.next = lists[mini];
			lists[mini] = lists[mini].next;
			r=r.next;
			r.next=null;
		}
        return head.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1,l2,l3,res;
		int[] in1 = {1,4,5}, in2 = {1,3,4}, in3 = {2,6};
		l1 = new ListNode(in1);
		l2 = new ListNode(in2);
		l3 = new ListNode(in3);
		ListNode[] lists = {null};
		res = mergeKLists2(lists);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}
