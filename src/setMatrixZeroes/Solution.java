package setMatrixZeroes;

import java.util.Arrays;
import java.util.HashSet;

/*
* 给矩阵置0，就是找矩阵中为0的元素，将其同行同列置0,必须是就地算法
* */
/*Input:
        [
        [1,1,1],
        [1,0,1],
        [1,1,1]
        ]
        Output:
        [
        [1,0,1],
        [0,0,0],
        [1,0,1]
        ]*/
public class Solution {
    private void setZeroes(int[][] matrix) {
        //最朴素想法，先找，然后置0
        //注意：置0不能影响后面
        HashSet<Integer> row = new HashSet<>(), col = new HashSet<>();
        if (matrix.length==0) return;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){// 填充0
                    row.add(i);
                    col.add(j);
                }
            }
        }
//        置0
        for (int i :
                row) {
            for (int k = 0; k < n; k++) matrix[i][k] = 0;
        }
        for (int j :
                col) {
            for (int k = 0; k < m; k++){
                matrix[k][j] = 0;
            }
        }
        for (int[] nums :
                matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }
    private void setZeroes2(int[][] matrix){
//        上一种方法，空间复杂度太高，为o(m*n),我们如何降到O(1)呢？
//        注意到当检查到matrix[i][j] == 0 ,不能直接所有行 列置0的原因是会影响下侧和右侧的判断
//        但是上侧和左侧不会影响，故我们不再使用HashMap，直接将matrix[i][0] = matrix[0][j] = 0 ,然后再检查一下行列开头即可
//        注意如果本来第0行或者第0列就有0，需要用一个flag来记忆一下，然后再判定置0
        int m = matrix.length, n = matrix[0].length;
        boolean isCol = false, isRow = false;
        for (int k = 0; k<m; ++k){
            if (matrix[k][0] == 0) {
                isCol = true; // 第一列应当置0
                break;
            }
        }
        for (int k = 0; k<n; ++k){
            if (matrix[0][k] == 0){
                isRow = true; // 第一行应当置0
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==0){// 填充0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i<m; i++){
            if (matrix[i][0] == 0){
                for (int j = 1; j<n; ++j) matrix[i][j] = 0;
            }
        }
        for (int j = 1; j<n; j++){
            if (matrix[0][j] == 0){
                for (int i = 1; i<m; ++i) matrix[i][j] = 0;
            }
        }

        if (isRow)   for (int k = 0; k<n; ++k) matrix[0][k] = 0;
        if (isCol)   for (int k = 0; k<m; ++k) matrix[k][0] = 0;

        for (int[] nums :
                matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input ={{1,0,3}};
        solution.setZeroes2(input);
    }
}
