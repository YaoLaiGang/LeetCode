package reorderList;

import java.util.ArrayList;

public class Solution {
    /*
    * 给一个链表 L1->L2->L3->...->Ln-2->Ln-1->Ln
    * 要求变成 L1->Ln->L2->Ln-1->L3->Ln-2->...
    * 思路：
    * 共有两种想法：
    * 1. 使用ArrayList将链表装进去，然后利用数组下标访问链表，可以轻易地完成
    * 2. 需要遍历两次链表
    *   2.1 首先利用快慢指针找到链表的中点，并断开为链表A，B
    *   2.2 后半段链表B就地逆置 B`
    *   2.3 同时遍历A B` 将B`的元素插入到A之后，直到B`的元素插入完毕
    * */
    public void reorderList(ListNode head) {
        // 这里先使用数组法实现，这种方法速度慢，占空间大，但是容易实现
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode p = head, q;
        int len = 0;
        while (p!=null){
            arr.add(p);
            ++len;
            p = p.next;
        }
        int i = 0, j = len-1;
        while (i<j){
            p = arr.get(i);
            q = arr.get(j);
            if (p.next!=q){
                q.next = p.next;
                p.next = q;
            }else{
                q.next = null;
            }
            i++;
            j--;
        }
        if (i==j) arr.get(i).next=null;
    }
}
