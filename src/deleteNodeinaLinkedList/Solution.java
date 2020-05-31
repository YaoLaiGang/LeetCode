package deleteNodeinaLinkedList;

public class Solution {
    /*
    * 给链表中的一个节点，要求删除链表中的这个节点(这个节点唯一，并且不是最后一个节点)
    * 使用覆盖法，从本节点开始遍历，让next节点的值覆盖本节点，依次步进
    * */
    public void deleteNode(ListNode node) {
        while (node.next!=null){
            node.val = node.next.val;
            if (node.next.next==null) node.next=null;
            else node = node.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){this.val=val;this.next=next;}
}