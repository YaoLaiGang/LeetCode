package spiralMatrixII;

import java.util.Arrays;

/*
* 这是矩阵旋转的变种问题
* 输入一个数n , 将 1-n^2个数按螺旋顺序填到N×N的格子里
*
* Input: 3
* Output:
* [
*  [ 1, 2, 3 ],
*  [ 8, 9, 4 ],
*  [ 7, 6, 5 ]
* ]
*
* 这个问题的本质问题还是遍历，和I没有很大的区别，而且是方阵，似乎更为简单
* */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n-1, left = 0, right = n-1, elem = 1;
        while (true){
//            上 左->右
            for (int j = left; j <= right; j++) {
                res[up][j] = elem++;
            }
            if (++up>down) break;
//            右 上->下
            for (int i = up; i <= down; i++) {
                res[i][right] = elem++;
            }
            if (--right<left) break;
//            下 右-> 左
            for (int j = right; j >= left; j--) {
                res[down][j] = elem++;
            }
            if (--down<up) break;
//            左 下-> 上
            for (int i = down; i >=up ; i--) {
                res[i][left] = elem++;
            }
            if (++left>right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.generateMatrix(1);
        for (int[] integer:
        res){
            System.out.println(Arrays.toString(integer));
        }
    }
}
