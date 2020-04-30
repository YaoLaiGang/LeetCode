package sortList;

import javax.sound.midi.Soundbank;
import java.util.List;

public class Solution {
    /*
    * 给链表排序，要求使用O(n)空间复杂度和O(n*logn)的时间复杂度
    * 首先满足O(n*logn)的排序算法有
    * 希尔排序，快速排序，归并排序，堆排序
    * 考虑使用快排或者归并排序
    * */
    public ListNode sortList(ListNode p) {
        if (p==null || p.next==null) return p;
        ListNode fast = p, slow = p, h2;
        while (slow != null){
            if (fast.next==null||fast.next.next==null){// 奇数节点，且slow已经在中点 || 偶数节点，在上中点
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        h2 = slow.next;
        slow.next = null;
        p = sortList(p);
        h2 = sortList(h2);
        return merge(p, h2);
    }
    public ListNode merge(ListNode h1, ListNode h2){
        /*
        * 将两个有序链表合并为一个
        * */
        ListNode p1 = h1, p2 = h2, p, head;
        if (h1.val<h2.val){
            p = h1;
            p1 = p1.next;
        }else {
            p = h2;
            p2 = p2.next;
        }
        head = p;
        while (p1!=null&&p2!=null){
            if (p1.val<p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!=null){
            p.next = p1;
        }
        if (p2!=null){
            p.next = p2;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] input1 = {2,1,-9};
        ListNode h = createByArr(input1);
        printList((new Solution()).sortList(h));
    }
    public static ListNode createByArr(int[] arr){
        if (arr.length<=0) return null;
        ListNode head = new ListNode(arr[0]), r = head;
        for (int i = 1; i < arr.length; i++) {
            r.next = new ListNode(arr[i]);
            r = r.next;
        }
        return head;
    }
    public static void printList(ListNode head){
        while (head!=null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}