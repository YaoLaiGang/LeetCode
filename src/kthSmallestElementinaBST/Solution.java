package kthSmallestElementinaBST;

import java.util.ArrayList;

public class Solution {
    /*
    * 在二叉搜索树中查找第K小的数字并返回，假设一定有解
    * 二叉搜索树的特性：如果二叉搜索树进行中序遍历，其结果一定是单调递增的
    * 采用用中序遍历(左根右)的顺序访问二叉搜索树，其顺序定为从小到大，取第K个即可
    * */
    private ArrayList<Integer> res = new ArrayList<>();
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res.get(k-1);
    }
    private void inOrder(TreeNode root){
        if (root==null) return;
        inOrder(root.left);
        if (res.size()==k) return;
        res.add(root.val);
        inOrder(root.right);
    }
}
