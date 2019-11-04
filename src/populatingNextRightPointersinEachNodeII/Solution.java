package populatingNextRightPointersinEachNodeII;

public class Solution {
    /*
    * 同populatingNextRightPointersinEachNodeI, 唯一的区别是这个树是不完全二叉树，I为完全二叉树
    * 也是递归非递归写法，非递归写法通用，这里不再复述
    * 必须注意的是，这里必须是根右左的顺序，之所以右左是因为next要向右查找，如果右边的next没有建立完整就会出错
    * 这道题还有改进空间
    * */
    public Node connect(Node root) {
        if (root==null) return null;
        Node p = root.next;
        while (p!=null){
            if (p.left!=null){
                p = p.left;
                break;
            }
            if (p.right!=null){
                p = p.right;
                break;
            }
            p=p.next;
        }
        if (root.right!=null) root.right.next = p;
        if (root.left!=null) root.left.next = root.right!=null?root.right:p;
        connect(root.right);//这里必须要先递归右节点
        connect(root.left);
        return root;
    }
}
