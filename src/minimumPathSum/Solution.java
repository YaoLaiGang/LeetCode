package minimumPathSum;

import java.util.Arrays;

/*
* 和Unique path类似，不过这里的m*n矩阵里有了数字
* 要求找一条从左上到右下的路径，使数字相加的和最小
* 由计数型动态规划转变为minmax动态规划
* */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] opt = new int[m][n];
        //边界处理
        opt[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) opt[i][0] = grid[i][0]+opt[i-1][0];
        for (int j = 1; j < n; j++) opt[0][j] = grid[0][j]+opt[0][j-1];
        //DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                opt[i][j] = grid[i][j]+Math.min(opt[i-1][j], opt[i][j-1]);
            }
        }
        for (int[] ele :
                opt) {
            System.out.println(Arrays.toString(ele));
        }
        return opt[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] input = {{1,3,1},{1,5,1},{4,2,1}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(input));
    }
}
