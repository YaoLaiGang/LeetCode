package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 接uniqueBinarySearchTreesII，也是给1……n个节点，这里是表示中序遍历（上一题是先序遍历）的结果
    * 生成所有可能的二叉树
    * 这里使用分治法，对[1...n]个元素，做如下操作：
    * 1. 定根节点
    * 2. 左孩子做同样的操作
    * 3. 右孩子做同样的操作
    * 最后保存该段所有可能的组合并返回
    *
    * 由于在递归过程中会出现很多的重复，可以使用一个数组保存需要的结果，如果有这个结果直接返回，以避免重复计算
    *
    * */
    private ArrayList<TreeNode>[][] memory; // 避免重复计算，增加记忆数组。
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>(), left, right;
        memory = new ArrayList[n][n];
        if (n==0) return res;
        for (int i = 1; i <= n; i++) {
            left = dfs(1, i-1);
            right = dfs(i+1, n);
            for (TreeNode l :
                    left) {
                for (TreeNode r :
                        right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return  res;
    }
    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>(), left, right;
        if (start>end){
            res.add(null);
            return res;
        }
        if (memory[start-1][end-1] != null) return memory[start-1][end-1];
        for (int i = start; i <= end; i++) {
            left = dfs(start, i-1);
            right = dfs(i+1, end);
            for (TreeNode l :
                    left) {
                for (TreeNode r :
                        right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        memory[start-1][end-1]= (ArrayList<TreeNode>) res;
        return  res;
    }
    public void preorderBTree(TreeNode root){
        if (root == null){
            System.out.print("null"+' ');
            return;
        }
        System.out.print(root.val+" ");
        preorderBTree(root.left);
        preorderBTree(root.right);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> res = solution.generateTrees(3);
        for (TreeNode t :
                res) {
            solution.preorderBTree(t);
            System.out.println();
        }
    }
}
