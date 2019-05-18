package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
/*
 * 通过旋转的顺序访问矩阵
 * 
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
设置四个变量 up down left right 来控制四个边界
按照螺旋顺序在四个边界跳动，当然边界会改变（当遍历完一行或是一列）
 * */
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length==0||matrix[0].length==0) return res;
        // 四个不可逾越的边界
		int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1;
		while (true){
			//上侧 左->右
			for (int j = left; j <= right; j++) {
				res.add(matrix[up][j]);
			}
			if (++up>down) break;
			//右侧 上->下
			for (int i = up; i <= down; i++) {
				res.add(matrix[i][right]);
			}
			if (--right<left) break;
			// 下侧 右->左
			for (int j = right; j >= left; j--) {
				res.add(matrix[down][j]);
			}
			if (--down<up) break;
			// 左侧 下->上
			for (int i = down; i >= up; i--) {
				res.add(matrix[i][left]);
			}
			if (++left>right) break;
		}
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		Solution solution = new Solution();
		List<Integer> res = solution.spiralOrder(matrix);
		for (Integer integer : res) {
			System.out.print(integer+" ");
		}
	}

}
