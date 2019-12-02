package lowestCommonAncestorofaBinarySearchTree;

public class Solution {
    /*
    * 寻找二叉搜索树中两节点的最低父节点
    * 使用深度优先遍历，分别查看左右子树是否含有p,q节点,最低父节点有个特点便是
    * 当其一个子树存在两个点时，不是最低节点，当左右子树各含有一个节点时，是最低的最低公共父节点
    *
    * 针对二叉搜索树，两节点的父节点其值肯定再两节点之间，可以进行剪枝
    * */
    private TreeNode res, p, q;
    private int min, max;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        min = Math.min(p.val, q.val);
        max = Math.max(p.val, q.val);
        contain(root);
        return  res;
    }
    private  boolean containBST(TreeNode root){
        if (root==null) return false;
        if (root.val>max) return contain(root.left);
        if (root.val<min) return contain(root.right);
        boolean a = contain(root.left), b = contain(root.right);
        if (a&&b) {
            res = root;
            return true;
        }
        if (root.val==p.val || root.val == q.val){
            if (a||b) res = root;
            return true;
        }
        return a||b;
    }
    private boolean contain(TreeNode root){
        if (root==null) return false;
        boolean a = contain(root.left), b = contain(root.right);
        if (a&&b) {
            res = root;
            return true;
        }
        if (root.val==p.val || root.val == q.val){
            if (a||b) res = root;
            return true;
        }
        return a||b;
    }
}
