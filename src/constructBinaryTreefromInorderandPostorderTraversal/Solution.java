package constructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;

public class Solution {
    /*
    * 这个和之前利用中序+前序的类似，只不过这个是后续遍历，也就是在定位根节点的时候是倒着来的
    * */
    private int[] postorder;
    private HashMap<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return createTree(0, postorder.length-1, 0, inorder.length-1);
    }
    private TreeNode createTree(int l1, int r1, int l2, int r2){
        if (l1>r1||l2>r2) return null;
        //1.后序序找root
        TreeNode root = new TreeNode(postorder[r1]);
        if (l1==r1) return root;
        //2.这里直接用Map查找
        int mid=inMap.get(postorder[r1]);
        root.left = createTree(l1, r1-(r2-mid)-1, l2, mid-1);
        root.right = createTree(r1-(r2-mid), r1-1, mid+1, r2);
        return root;
    }
}
