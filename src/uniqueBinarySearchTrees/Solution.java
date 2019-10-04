package uniqueBinarySearchTrees;

import java.util.Arrays;

public class Solution {
    /*
    * 给一个数n,表示从1……n个TreeNode,求这n个节点能产生多少二叉树
    * 分治法，先定根节点，然后分左右字节点
    * 1
    * 2
    * 5
    * 14
    * 42
    * 你会发现这是卡特兰数数列，没错，这就是卡特兰数数列的性质之一
    * */
    public int numTrees(int n) {
        long[] res = new long[n+1];
        res[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            res[i] = (((4*(i-1)+2)*res[i-1])/((i-1)+2));
        }
        System.out.println(Arrays.toString(res));
        return (int)res[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(19));
    }
}
