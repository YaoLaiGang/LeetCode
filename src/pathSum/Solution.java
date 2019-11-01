package pathSum;

public class Solution {
    /*
    * 在二叉树找一条从根节点到叶子节点的路径，要求这条路径上所有节点的和等于sum
    * 如果能找到返回true，否则返回false
    * 这个题目是一个典型的遍历题，并且应该是深度优先遍历，使用DFS搜索大法即可
    * 当然可以剪枝
    * */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) return false;
        return findPath(root, sum);
    }
    private boolean findPath(TreeNode root, int sum){
        if (root==null) return false;
        if (root.left == null&&root.right==null){//叶子节点
            return sum==root.val;
        }
        return findPath(root.left, sum-root.val)||findPath(root.right, sum-root.val);
    }
}
