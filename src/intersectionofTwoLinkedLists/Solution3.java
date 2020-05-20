package intersectionofTwoLinkedLists;


public class Solution3 {
    /*
    * 第三个角度，我们可以把其中一条路径变成环
    * 当其中一个节点到达末尾时，令其跳到另一个节点的开头
    * 1. 当两节点相遇时，一定是相交节点，因为这种走法实际上是弥补了两条路径不等长的问题，由于两指针走的长度时相同的
    * 为两条路径之和
    * 2. 当两节点同时为空指针时，说明路径中没有交点
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA, p2 = headB;
        if (p1==null||p2==null) return null;
        while (p1 != p2){
            if (p1==null) p1 = headB;
            else p1 = p1.next;
            if (p2==null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
