package populatingNextRightPointersinEachNode;

public class Solution2 {
    /*
    * 该问题还有递归解法，通过该层建立好了的next来给构建下一层的next
    * */
    public Node connect(Node root){
        if (root==null) return null;
        if (root.left!=null) {// 有孩子
            root.left.next = root.right;
            if (root.next!=null) root.right.next = root.next.left;//有兄弟，也有孩子，有兄弟没孩子没意义
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
