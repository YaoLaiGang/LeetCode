package AddTwoNumber;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;
/*
 * 大整数求和,将两个大于零的大整数逆置放入链表,然后求和,以链表形式返回
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/
public class Solution {
	public static ListNode addTwoNumbers(ListNode num1,ListNode num2){
	ListNode res=null,s,tem,r=res;
	int j=0,c;//记录进位
	while(num1!=null&&num2!=null)
	{
		c=num1.val+num2.val+j;
		if(c<=9)
		{
			s=new ListNode(c);
			j=0;
		}
		else{
			j=c/10;
			s=new ListNode(c%10);
		}
		if(res==null){
			res = s;
			r=res;
		}
		else{
		r.next=s;
		r=s;
		}
		num1=num1.next;
		num2=num2.next;
	}
	tem = num1==null?num2:num1;
	//处理剩下的
	while(tem!=null)
	{
		c=j+tem.val;
		if(c<=9)
		{
			s=new ListNode(c);
			j=0;
		}
		else{
			j=c/10;
			s=new ListNode(c%10);
		}
		r.next=s;
		r=s;
		tem=tem.next;
	}
	//最后进位处理
	if(j!=0)
	{
		while(j!=0)
		{
			s=new ListNode(j%10);
			r.next=s;
			r=s;
			j/=10;
		}
	}
	r.next=null;
	return res;
}
	public static void main(String[] args) {
		int[] a ={9},b={1,9,9,9,9,9,9,9,9,9};
		ListNode l1 = new ListNode(a),l2 = new ListNode(b);
		(addTwoNumbers(l1, l2)).printList();
	}

}
