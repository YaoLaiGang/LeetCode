package sumRoottoLeafNumbers;

public class Solution {
    /*
    这道题的要求是，将树中所有根节点到叶子节点的路径上的数字组成分别组成相应的数字，然后相加
    最后求出相加的和
    思路：仍然是使用DFS遍历，中途记录需要的数字，遇到新数字就*10+1
    * */
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return res;
        preOrder(root, 0);
        return res;
    }
    private void preOrder(TreeNode root, int preRes){
        preRes = preRes*10 + root.val;
        if (root.left==null&&root.right==null){// 叶子节点，已经组成了一条路径
            res += preRes;
            System.out.println(preRes);
            return;
        }
        if (root.left!=null){
            preOrder(root.left, preRes);
        }
        if (root.right!=null){
            preOrder(root.right, preRes);
        }
    }
}
