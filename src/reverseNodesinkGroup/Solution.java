package reverseNodesinkGroup;


public class Solution {
/**
 * 和 swapNodesinPairs类似，那个算法要求两个一组求逆
 * 这个算法给了一个K，要求K个一组逆置
 * 
 * 思路：使用尾插法
 * */
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode p=head,tmp=head,realHead = new ListNode(-1), pre= realHead, rear=p;
		int count = 0, length=0, n=0;
		while(tmp!=null){
			length++;
			tmp=tmp.next;
		}
		if(length<k) return head;
		length/=k;
		realHead.next=null;
		while(p!=null){
			System.out.println("p:"+p.val); 
			if(count==k) {
				n++;
				if(n==length){
					rear.next = p;
					break;
				}
				pre = rear;
				count=0;
				rear = p;
			}
			tmp = p;
			p=p.next;
			tmp.next = pre.next;
			pre.next = tmp;
			count++;
		}
        return realHead.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4,5};
		ListNode head = new ListNode(input), res;
		int k = 5;
		res = reverseKGroup(head, k);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}
