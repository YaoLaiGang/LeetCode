package flattenaMultilevelDoublyLinkedList;

public class Solution {
    /*
    * 将多层双向链表摊平，这里的双向链表多了一个child指针，可能会指向另一个双向链表(子链表)
    * 本算法要实现的目标就是将多层链表变成一层举例如附带的图像所示
    * 考虑使用递归法，当出现分支时调用递归算法，递归算法返回最后一个元素，以便于插入到当前节点之后
    * */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    public Node dfs(Node head){
        Node p = head, tmp = null, rear = null;
        while (p!=null){
            if (p.child!=null){
                Node q = dfs(p.child);
                tmp = p.next; // 暂存以便遍历
                if (tmp == null) {
                    rear = p;
                }else {
                    q.next = tmp;
                    tmp.prev = q;
                }
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
                p = tmp;
            }else{
                if (p.next==null) rear = p;
                p = p.next;
            }
        }
        return rear;
    }
}
class Node{
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}