package recoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    /**
     * 给一个非二叉搜索树，令其成为二插搜索树
     * 一种办法是O(N)空间的方法，使用中序遍历的特性来更改节点的元素值，使得元素值有序
     *
     */
    private ArrayList<TreeNode> inorder;
    private ArrayList<Integer> val;
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        inorder = new ArrayList<>();
        val = new ArrayList<>();
        inorderBT(root);
        //对val排序，插入对应的TreeNode
        Collections.sort(val);
        int len = inorder.size();
        for (int i = 0; i < len; i++) {
            inorder.get(i).val = val.get(i);
        }
    }
    private void inorderBT(TreeNode root){
        if (root==null) return;
        inorderBT(root.left);
        inorder.add(root);
        val.add(root.val);
        inorderBT(root.right);
    }
}
