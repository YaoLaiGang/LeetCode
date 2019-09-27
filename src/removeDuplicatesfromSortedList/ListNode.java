package removeDuplicatesfromSortedList;

public class ListNode {
	int val;
    ListNode next;
    
    ListNode(int x){ 
  	  val = x; 
    }
    
    public ListNode(int[] input) {//使用尾插法进行初始化
    	if(input.length==0) return;
    	this.val = input[0];
    	ListNode r = this; //尾指针
    	for (int i = 1; i < input.length; i++) {
			r.next = new ListNode(input[i]);
			r = r.next;
		}
    }
}
