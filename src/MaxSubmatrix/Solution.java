package MaxSubmatrix;

import java.util.Arrays;

public class Solution {
    /*
    * 这个题目的大意是给一个数组，求出其最大子数组(和为最大)
    * 返回一个数组[r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。
    *
    * 思路：我们做过MaxSubArray b[i] = max(b[i-1]+a[i], a[i]),只要我们固定了需要的行[i,j]
    * 将其对应列求和压缩，就可使用MaxSubArray求出哪列最大
    * 我们需要做的就是不断变换i,j，找出使得这个和最大的下标
    * */
    public int[] maxSubArray(int[] arr){
        int[] res = new int[3], b = new int[arr.length];
        int max = arr[0], begin = 0, end = 0;
        b[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (b[i-1]+arr[i] > arr[i]){
                b[i] = b[i-1]+arr[i];
                end = i;
            }else{
                b[i] = arr[i];
                begin = i;
                end = i;
            }
            if (b[i]>max) {
                max = b[i];
                res[0] = begin;
                res[1] = end;
                res[2] = max;
            }
        }
        return res;
    }
    public int[] getMaxMatrix(int[][] matrix) {
        int[] res = new int[4], sum, tmpRes = new int[3];
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            sum = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                // 第 i-j 行
                for (int k = 0; k < sum.length; k++) {
                    sum[k]+=matrix[j][k];
                }
                tmpRes = maxSubArray(sum);
                if (max<tmpRes[2]){
                    res[0] = i;
                    res[1] = tmpRes[0];
                    res[2] = j;
                    res[3] = tmpRes[1];
                    max = tmpRes[2];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(Arrays.toString(solution.maxSubArray(arr)));
        int[][] matrix = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1},{1,0,0,1,0}};
        System.out.println(Arrays.toString(solution.getMaxMatrix(matrix)));
    }
}
