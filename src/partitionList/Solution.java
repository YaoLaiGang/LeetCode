package partitionList;

import java.util.Arrays;

public class Solution {
/*
* 划分链表，就是把链表分成两半，左边的小于x，右边的大于x
* 可以先建立两个链表，遍历给的链表，小的给一个，大的给一个（均使用尾插法）,最后两个链表合并
* */
    public ListNode partition(ListNode head, int x) {
        ListNode minH = new ListNode(-1), maxH = new ListNode(-1), p = head, minR = minH, maxR = maxH;
        while (p!=null){
            if (p.val<x){
                minR.next = p;
                minR = minR.next;
            }
            else{
                maxR.next = p;
                maxR = maxR.next;
            }
            p = p.next;
        }
        minR.next = null;
        maxR.next = null;
        minR.next = maxH.next;
        return  minH.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,4,3,2,5,2};
        ListNode listNode = new ListNode(input);
        listNode = solution.partition(listNode, 1);
        while (listNode!=null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
    }
}
