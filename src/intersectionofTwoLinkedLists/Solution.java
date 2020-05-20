package intersectionofTwoLinkedLists;

import java.util.HashSet;

public class Solution {
    /*
    * 这个题目的问题是是寻找两链表的相交点。
    * 具体思路是利用HashSed给每个点加一个访问标记，如果发现访问的节点再Set里说明是交点
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        HashSet<ListNode> visited = new HashSet<ListNode>();
        while (pa!=null&&pb!=null){
            if (visited.contains(pa)) return pa;
            else visited.add(pa);
            if (visited.contains(pb)) return pb;
            else visited.add(pb);
            pa = pa.next;
            pb = pb.next;
        }
        while (pa!=null){
            if (visited.contains(pa)) return pa;
            else visited.add(pa);
            pa = pa.next;
        }
        while (pb!=null){
            if (visited.contains(pb)) return pb;
            else visited.add(pb);
            pb = pb.next;
        }
        return null;
    }
}
