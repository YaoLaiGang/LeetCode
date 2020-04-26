package copyListwithRandomPointer;

public class Solution2 {
    /*
    * 使用HashMap会浪费大量的内存，这里我们采用另一种方法
    * 1. 第一次遍历，在每个节点后面都生成它的拷贝节点
    * 2. 第二次遍历，连接random指针
    * 3. 第三次遍历，抽取所有的拷贝节点
    * */
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node p = head, rp, res;
        while (p!=null){// 第一次遍历，生成拷贝节点
            Node n = new Node(p.val), next = p.next;
            n.next = p.next;
            p.next = n;
            p = next;
        }
        // 第二次遍历， 连接拷贝出来的random节点
        p = head;
        while (p!=null){
            if (p.random!=null) p.next.random = p.random.next;
            p = p.next.next;
        }
        // 第三次遍历， 连接所有的拷贝节点
        p = head;
        rp = head.next;
        res = head.next;
        while (p!=null){
            p.next = rp.next;
            if (rp.next!=null) rp.next = rp.next.next;
            p = p.next;
            rp = rp.next;
        }
        return res;
    }
}
