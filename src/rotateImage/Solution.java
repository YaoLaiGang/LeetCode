package rotateImage;

import java.util.Arrays;

public class Solution {
/*
 * 将矩阵顺时针旋转90，就地旋转,不得使用额外辅助空间
 * 
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
[
  [(0,0),(0,1),(0,2)],
  [(1,0),(1,1),(1,2)],
  [(2,0),(2,1),(2,2)]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
[
  [(2,0),(1,0),(0,0)],
  [(2,1),(1,1),(0,1)],
  [(2,2),(1,2),(0,2)]
]
第一行是原倒置第一列
第二行是原倒置第二列
第三行是原倒置第三列
新位置下标：
(i,j)->(j,i)->(j, (n-1)-i)
上一个位置
(i,j)->(i,-(j-(n-1))->(n-1-j, i)
思路，每次循环四个数字
 * */	
	public void rotate(int[][] matrix) {
		int n = matrix[0].length;
        for(int i=0; i<n/2; ++i){//控制层数
        	for (int j = i; j<n-1-i; j++) {//控制变换列数，到下个变换点之前都要变换一圈
        		int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {};
		for (int[] is : input) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
		Solution solution = new Solution();
		solution.rotate(input);
		for (int[] is : input) {
			System.out.println(Arrays.toString(is));
		}
	}

}
