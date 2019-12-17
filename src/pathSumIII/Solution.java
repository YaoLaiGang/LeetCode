package pathSumIII;

import java.util.ArrayList;

public class Solution {
    /*
    * 从二叉树中找符合加和为sum的路径
    * 这条路径仅要求从上到下，不要求从父节点开始
    * 返回所有符合条件的路径的个数
    *
    * 思路：
    * 1. 朴素解法，带一个数组记录访问的路径，然后从数组中逐个排除前面的节点，以查找可能的解
    * 2. 遍历path，逐层递减有些麻烦，如果能直接求得所要数字可能会更快一些
    * */
    private int sum = 0, res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        this.sum = sum;
        ArrayList<Integer> path = new ArrayList<>();
        findSum(root, path, 0);
        return res;
    }
    private void findSum(TreeNode root, ArrayList<Integer> path, int curSum){
        if (root==null) return;
        curSum += root.val;
        if (curSum==sum) ++res;
        path.add(root.val);
        int t = curSum;
        for (int i = 0; i < path.size() - 1; i++) {
            t -= path.get(i);
            if (t==sum) ++res;
        }
        findSum(root.left, path, curSum);
        findSum(root.right, path, curSum);
        path.remove(path.size()-1);
    }
}
