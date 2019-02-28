package swapNodesinPairs;

public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x){ 
	    	  val = x; 
	      }
	      public ListNode(int[]input) {
			// TODO Auto-generated constructor stub
	    	this.val = input[0];
	    	ListNode last = this;// 尾插法
	    	for(int i = 1; i<input.length; ++i){
	    		last.next = new ListNode(input[i]);
	    		last = last.next;
	    	}
		}
}
