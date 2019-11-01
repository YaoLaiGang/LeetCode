package pathSumII;

import convertSortedListtoBinarySearchTree.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 接上一题，这一题要求把符合条件的路径保存并返回
    * */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null) return res;
        List<Integer> tmp = new ArrayList<>();
        findPath(root, sum, tmp);
        return res;
    }
    private void findPath(TreeNode root, int sum, List<Integer> tmp){
        if (root==null) return;
        tmp.add(root.val);
        if (root.left == null&&root.right==null){//叶子节点,保存结果
            if (sum==root.val){
                res.add(new ArrayList<>(tmp));
            }
        }
        findPath(root.left, sum-root.val, tmp);
        findPath(root.right, sum-root.val, tmp);
        tmp.remove(tmp.size()-1);
    }
}
