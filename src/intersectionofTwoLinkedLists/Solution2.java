package intersectionofTwoLinkedLists;

public class Solution2 {
    /*
    * 另一个角度想，造成难以查找的问题在哪？
    * 对，就是交点前的两链表长度不定，如果长度相同，那么大家一起遍历肯定能找到这个节点
    * 因此我们的思路二也很简单，就是让两链表长度相同
    * 1. 分别遍历两链表，求得两链表的长度，那么其差值就是就是不等长的根源所在
    * 2. 让长的链表先遍历长度差，使得两链表相对等长
    * 3. 同时遍历两链表，遍历到相同的节点就是我们要找的结果
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode pa = headA, pb = headB;
        while (pa!=null){
            ++lenA;
            pa = pa.next;
        }
        while (pb!=null){
            ++lenB;
            pb = pb.next;
        }
        pa = lenA > lenB ? headA : headB;
        pb = lenA > lenB ? headB : headA;
        lenA = Math.abs(lenA-lenB);
        while (lenA!=0){
            pa = pa.next;
            lenA--;
        }
        while (pa!=null&&pb!=null){
            if (pa==pb) return pa;
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
