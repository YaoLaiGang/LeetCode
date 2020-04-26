package copyListwithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /*
    * 这个问题是拷贝带有随机指针的链表，随机指针就是一个乱指的指针
    * 注意: 不知道为什么, 使用HashMap的时候克隆链表不能改动，否则会造成混淆，现在还不知道原因
    * 思路：先使用HashMap（ArrayList）生成 旧链-新链 的映射。再二次遍历旧链，连接对应的新链
    * */
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node p = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (p!=null){
            map.put(p, (new Node(p.val)));
            p = p.next;
        }
        p = head;
        while (p!=null){
            if (p.next!=null) map.get(p).next = map.get(p.next);
            if (p.random!=null) map.get(p).random = map.get(p.random);
            p=p.next;
        }
        return map.get(head);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
