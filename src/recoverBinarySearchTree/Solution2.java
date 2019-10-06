package recoverBinarySearchTree;

public class Solution2 {
    /*
    * 方法一中，保存所有的元素浪费了大量的空间，实际上需要改变的只有两个乱序的节点，只要把这两个乱序值改变即可
    * 设置pre first second指针
    * pre表示中序遍历中当前节点的前一个节点
    * first表示第一个乱序的节点，second表示最后一个乱序的节点
    * */
    private TreeNode pre = null, first = null, second = null;
    public void recoverTree(TreeNode root){
        inorderBT(root);
        if (first!=null&&second!=null){
            first.val = first.val+second.val;
            second.val = first.val - second.val;
            first.val = first.val - second.val;
        }
    }
    private void inorderBT(TreeNode root){
        if (root==null) return;
        inorderBT(root.left);
        if (pre==null) pre = root;
        else {
            if (pre.val>root.val){
                if (first==null) first=pre;
                second = root;
            }
            pre = root;
        }
        inorderBT(root.right);
    }
}
