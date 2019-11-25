package binaryTreeMaximumPathSum;

public class Solution {
    //在二叉树中寻找一条路径，该路径不要求从根结点出发，只需要其路径之和为最大即可，返回这个最大值
    // 思路：使用深度优先遍历，维护一个最大值， 将左右子树和根中所有的正的值加起来和最大值比较，并返回以该点为根的最大值
    private int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        return Math.max(backOrder(root), maxVal);
    }
    private int backOrder(TreeNode root){
        if (root.left==null&&root.right==null){
            //叶子节点，此时只需要将根节点和maxValue即可
            maxVal = Math.max(root.val, maxVal);
            return root.val;
        }
        if (root.left==null){// 没有左孩子
            int r = backOrder(root.right);
            if (root.val<0){// 此时加上根部反而会变小，左右子树的和可能会产生最大值
                maxVal = Math.max(maxVal, r);
            }
            maxVal = Math.max(root.val+Math.max(r,0), maxVal);
            return Math.max(root.val+r, root.val);
        }
        if (root.right==null){// 没有右孩子
            int l = backOrder(root.left);
            if (root.val<0){// 此时加上根部反而会变小，左右子树的和可能会产生最大值
                maxVal = Math.max(maxVal, l);
            }
            maxVal = Math.max(root.val+Math.max(l,0), maxVal);
            return Math.max(root.val+l, root.val);
        }
        int left = backOrder(root.left), right = backOrder(root.right);
        int a = Math.max(left, 0), b = Math.max(right,0);
        if (root.val<0){// 此时加上根部反而会变小，左右子树的和可能会产生最大值
            maxVal = Math.max(maxVal, Math.max(left,right));
        }
        maxVal = Math.max(maxVal, a+b+root.val);// a+b的正值和root抵消后也有可能产生最大值
        System.out.println(root.val+":"+maxVal);
        return root.val+Math.max(a,b); // 表示带上根节点的最大值，需要给上层使用,这里要注意由于路径不能分叉所以只能选一个最大的返回
    }
}
