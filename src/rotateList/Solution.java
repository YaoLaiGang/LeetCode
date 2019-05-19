package rotateList;
/*
* 旋转列表，其实就是约瑟夫环的其中一步
*
*
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL


Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

*可以先设计成循环链表，前进 List.len - k%list.len-1步,断开其和next的连接即可
* 注意，求长度需要全部遍历一遍
* */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return null;
        int n=1;
        ListNode p = head;
        while (p.next!=null){
            ++n;
            p = p.next;
        }
        p.next = head; // 循环链表
        n = n - k%n; //前进步数
        while (n!=0){
            p = p.next;
            --n;
        }
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] input = {0};
        ListNode list = new ListNode(input);
        Solution solution = new Solution();
        ListNode head = solution.rotateRight(list, 1);
        while (head!=null){
            System.out.print(head.val+"\t");
            head=head.next;
        }
    }
}
