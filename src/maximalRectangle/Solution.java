package maximalRectangle;

public class Solution {
    /*
    * 给一个二维矩阵，其中只有元素1和0，现在求一个子矩阵
    * 要求其中只有1且其面积最大
    * 思路：
    * 和MaxSubmatrix有些类似，我们需要设计一个函数，该函数来找寻一个数组中某个值最大连续次数
    * 我们仍然限定到第1-j行，将其压缩，然后利用上述函数找到找到最大值为j-i+1的最大连续个数
    * 这样就保证了其在横向和纵向都是连续的1，最后记录最大的max即可
    * */
    public int findMaxValue(int[] arr, int value){
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value) ++count;
            else count = 0;
            if (count>max) max = count;
        }
        return max*value;
    }
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                // i-j进行求和，i不动，j从i到底依次遍历，加和
                for (int k = 0; k < sum.length; k++) {
                    sum[k] += matrix[j][k]-'0';
                }
                int tmpMax = findMaxValue(sum, j-i+1);
                max = Math.max(tmpMax, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = {{'1','0','1','0','0'},{'1','0','0','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle(input));
    }
}
