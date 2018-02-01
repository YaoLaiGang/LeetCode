package AddTwoNumber;

public class ListNode {
  int val;
  public ListNode next;
  public ListNode(int x) { val = x; }
  public ListNode(int[] a){
	  ListNode s,r;
	  r=this;
	  for (int i = 0; i < a.length; i++) 
	  {
		s=new ListNode(a[i]);
		r.next=s;
		r=s;
	  }
	  r.next=null;
  }
  public void printList()
  {
	  ListNode p=this;
	  while(p!=null)
	  {
		  System.out.print(p.val+"\t");
		  p=p.next;
	  }
  }
}
