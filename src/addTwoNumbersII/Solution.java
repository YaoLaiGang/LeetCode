package addTwoNumbersII;

import java.util.Stack;

public class Solution {
    /*
    * 大整数求和进阶版，在I中是位数相等的两个大整数求和，这里是两个位数不等的大整数求和，并且这次题目将不允许逆置链表
    * 思路，由于不能逆置，因此需要保存中途的结果，这里考虑使用栈结构，由于是后入先出，所以低位先出栈进行运算
    * 同时申请一个变量来保存进位结果，对于结果链表使用头插法即可,另外和I一样，注意最后的进位可能会造成整体位数增加，如99+1
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), p1 = l1, p2 = l2;
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (p1!=null){
            s1.push(p1.val);
            p1 = p1.next;
        }
        while (p2!=null){
            s2.push(p2.val);
            p2 = p2.next;
        }

        int a, b, c = 0, sum;
        while (!s1.empty()&&!s2.empty()){
            a = s1.pop();
            b = s2.pop();
            sum = a+b+c;
            c = sum/10; // 高位
            ListNode n = new ListNode((sum)%10); // 低位
            n.next = res.next;
            res.next = n; // 尾插法
        }

        //处理剩余高位部分
        while (!s1.empty()){
            a = s1.pop();
            sum = a+c;
            c = sum/10;
            ListNode n = new ListNode((sum)%10);
            n.next = res.next;
            res.next = n;
        }
        while (!s2.empty()){
            b = s2.pop();
            sum = b+c;
            c = sum/10;
            ListNode n = new ListNode(sum%10);
            n.next = res.next;
            res.next = n;
        }
        // 最后可能会多一位
        if (c!=0){
            ListNode n = new ListNode(c);
            n.next = res.next;
            res.next = n;
        }
        return res.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; };
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}