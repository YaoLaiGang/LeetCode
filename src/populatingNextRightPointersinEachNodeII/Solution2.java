package populatingNextRightPointersinEachNodeII;

public class Solution2 {
    /*
    * 想实现一个100%的方法，这里想使用两个指针完成,PS：这就是100%的方法
    * 一个指针指向本层最左边节点，另一个指针向右遍历next,然后给其孩子节点穿针，并且其孩子节点穿针的时候要顺便找到下一层的第一个节点
    * */
    public Node connect(Node root) {
        Node head = root, pre, cur;//head是每一层的开头，p是当前节点，pre的next是p
        while (head!=null){
            // 一层遍历开始
            pre = null;
            cur = head;
            head = null;
            while (cur != null){
                System.out.println(cur.val);
                if (cur.left!=null){
                    if (pre==null){
                        head = cur.left;
                    }else{
                        pre.next = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right!=null){
                    if (pre==null){
                        head = cur.right;
                    }else{
                        pre.next = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}
