package searchA2DMatrix;
/*
* 这题有点意思，在二维数组中查找数据，二维数组有如下特性：
* 1.每一行都已经排好序
* 2.每一行的开头都大于上一行的最后一个元素
* */
/*Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        Output: true*/
/*Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 13
        Output: false*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        * 想法，肯定是先比较右侧边界，先找到数字到底在哪一行，如果小于这一行的右侧数字所以在本行（由上到下）
        * 然后在本行调用二分等快速查找法即可
        * */
        if (matrix.length==0||matrix[0].length==0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target<matrix[i][n-1]){// target在本行，对本行进行搜索
                if (target<matrix[i][0]) return false;
                // 二分搜索
                int left = 0, right = n-1, mid;
                while (left<=right){
                    mid = (left+right)/2;
                    if (matrix[i][mid] == target) return true;
                    else if (target>matrix[i][mid]) left = mid+1;
                    else right = mid-1;
                }
                return  false;
            }else if (target == matrix[i][n-1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input =  {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(input, 21));
    }
}
