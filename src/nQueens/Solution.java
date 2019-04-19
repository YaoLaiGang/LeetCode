package nQueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
/*
 * n皇后问题，在N×N的棋盘放N个皇后，要求N个皇后
 * 1.不同行
 * 2.不同列
 * 3.不在同一条斜线
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
思路：和解决数独问题一样，使用回溯法填充棋盘
 * */
	private int n;
	public List<List<String>> solveNQueens(int n) {
		this.n = n;
        List<List<String>> res = new ArrayList<List<String>>(),board = new ArrayList<List<String>>();
        for(int i=0; i<n; ++i){
        	ArrayList<String> list = new ArrayList<String>(Collections.nCopies(n, "."));
        	board.add(list);
        }
        dfs(0, board, res);
        return res;
    }
	public void dfs(int row, List<List<String>> board, List<List<String>> res) {
		if(row == n){// 找到一个解
			printRes(board);
			// 每行拆成一条数组，放入res中
			ArrayList<String> arr = new ArrayList<String>();
			for (List<String> list : board) {
				StringBuilder sBuilder = new StringBuilder();
				for (String string : list) {
					sBuilder.append(string);
				}
				arr.add(sBuilder.toString());
			}
			res.add(arr);
		}
		for(int j=0; j<n; ++j){
			if(isFill(row, j, board)){//可以填皇后，深度搜索
				board.get(row).set(j, "Q");
				dfs(row+1, board, res);
				board.get(row).set(j, ".");//回溯
			}
		}
	}
	public boolean isFill(int row, int col, List<List<String>> board) {
//		正上方/斜线检查
		for (int i = 0; i < row; i++) {
			if(board.get(i).get(col)=="Q") return false;
			int j = col-(row-i);//主斜线
			if(j>=0&&board.get(i).get(j)=="Q") return false; 
			j = col + (row-i);//副斜线
			if(j<n&&board.get(i).get(j)=="Q") return false; 
		}
		return true;
	}
	public void printRes(List<List<String>> res) {
		for (List<String> list : res) {
			for (String string : list) {
				System.out.print(string+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<List<String>> res = solution.solveNQueens(5);
//		for (List<String> list : res) {
//			for (String string : list) {
//				System.out.println(string);
//			}
//			System.out.println();
//		}
	}

}
