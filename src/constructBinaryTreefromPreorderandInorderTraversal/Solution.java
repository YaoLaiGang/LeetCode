package constructBinaryTreefromPreorderandInorderTraversal;

import java.util.HashMap;

public class Solution {
    /*
    * 经典题目，根据前序遍历和中序遍历构造二叉树
    * 通过前序遍历找根节点，通过中序遍历划分左右子树
    * 经典的分治法思想
    * --> 进阶版，这样速度还是很慢，主要是每次从中序遍历中寻找左右子树的速度太慢，可以考虑用HashMap先映射，这样来加快速度
    * */
    private int[] preorder, inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return createTree(0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode createTree(int l1, int r1, int l2, int r2){
        if (l1>r1||l2>r2) return null;
        //1.前序找root
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1==r1) return new TreeNode(preorder[l1]);
        //2.中序找左右子树
        int mid=l2;
        for (int i = l2; i <= r2; i++) {
            if (inorder[i]==preorder[l1]){
                mid = i;
                break;
            }
        }
        root.left = createTree(l1+1, l1+(mid-l2), l2, mid-1);
        root.right = createTree(l1+(mid-l2+1), r1, mid+1, r2);
        return root;
    }

    /*
    * 方法二，在方法一的基础上增加HashMap
    * */
    private HashMap<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return createTree(0, preorder.length-1, 0, inorder.length-1);
    }
    private TreeNode createTree2(int l1, int r1, int l2, int r2){
        if (l1>r1||l2>r2) return null;
        //1.前序找root
        TreeNode root = new TreeNode(preorder[l1]);
        if (l1==r1) return new TreeNode(preorder[l1]);
        //2.这里直接用Map查找
        int mid=inMap.get(preorder[l1]);
        root.left = createTree(l1+1, l1+(mid-l2), l2, mid-1);
        root.right = createTree(l1+(mid-l2+1), r1, mid+1, r2);
        return root;
    }
}
