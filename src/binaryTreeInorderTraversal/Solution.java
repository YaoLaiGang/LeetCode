package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
    * 二叉树中序遍历
    * 左根右，使用递归最为方便
    * 输入是数组表示的二叉树，并且是前序遍历的顺序
    * */
    static private int index = 0;
    ArrayList<Integer> res = new ArrayList<Integer>();
    public TreeNode createTreeByPre(Integer[] nums){
        // 以this为根节点，创建二叉树
        if (index>=nums.length) return null;
        if (nums[index] == null) return null;
        TreeNode root = new TreeNode(nums[index]);
        index++;
        root.left = createTreeByPre(nums);
        index++;
        root.right = createTreeByPre(nums);
        return root;
    }
    public List<Integer> inOrderTraversal(TreeNode root){
        if (root==null) return res;
        inOrderTraversal(root.left);
        res.add(root.val);
        inOrderTraversal(root.right);
        return res;
    }
    private List<Integer> inorderTraversal(TreeNode root){
//        非递归中序遍历，左根右顺序
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p!=null||!s.isEmpty()){
            while (p!=null){//有左孩子，稍等访问，入栈
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()){//此时p一定没有左孩子，直接访问
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return  res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] input = {1,null,2,3};
        TreeNode root = solution.createTreeByPre(input);
        solution.inorderTraversal(root);
        System.out.println(solution.res);
    }
}
