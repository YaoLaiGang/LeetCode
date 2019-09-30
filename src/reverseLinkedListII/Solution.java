package reverseLinkedListII;

public class Solution {
    /*
    * 链表逆置升级版，这里是指定[m,n]的元素逆置
    * 头插法可以解决这一个问题，就地逆置法难以使用
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //头插法逆置法
        //找到待逆置点
        if (head==null) return null;
        int count = 1;
        ListNode top = new ListNode(-1);
        top.next = head;
        ListNode q = top, p = head, r, tmp;
        while (p!=null&&count<m){
            q = p;
            p = p.next;
            count++;
        }
        if (p==null) return head;//不需要逆置
        r = p; //最后衔接
        p = p.next;
        ++count;
        //以q为头部开始头插法
        while (p!=null&&count<=n){
            tmp = p.next;
            p.next = q.next;
            q.next = p;
            p = tmp;
            r.next=tmp;
            ++count;
        }
        return top.next;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        ListNode res = (new Solution()).reverseBetween((new ListNode(input)), 1,3);
        while (res != null){
            System.out.println("res = " + res.val);
            res = res.next;
        }
    }
}
