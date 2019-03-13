package validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
/**
 * 判定数独是否符合规范
 * 1.每一行不能有重复元素
 * 2.每一列不能有重复元素
 * 3.每个3*3的格子不能有重复元素
 * 输入的是9*9的盒子
 * 如：
 * [
  ['5','3','.','.','7','.','.','.','.'],
  ['6','.','.','1','9','5','.','.','.'],
  ['.','9','8','.','.','.','.','6','.'],
  ['8','.','.','.','6','.','.','.','3'],
  ['4','.','.','8','.','3','.','.','1'],
  ['7','.','.','.','2','.','.','.','6'],
  ['.','6','.','.','.','.','2','8','.'],
  ['.','.','.','4','1','9','.','.','5'],
  ['.','.','.','.','8','.','.','7','9']
]
 * */		
		HashMap<Character, Integer[][]> hMap =new HashMap<>();
		Integer[][] tmp;
		Integer[] save,integers;
		int k;
		for (int i = 0; i < 9; i++) {
			for(int j = 0; j<9; j++){
				if(board[i][j]=='.') continue;
				if (hMap.containsKey(board[i][j])) {
					tmp = hMap.get(board[i][j]);
					for (k = 0; tmp[k]!=null&&k< 9; ++k) {
						integers = tmp[k];
						if(integers[0]==i||integers[1]==j) return false;
						if(integers[0]/3==i/3&&integers[1]/3==j/3) return false;
					}
					save = new Integer[2];
					save[0] = i;
					save[1] = j;
					tmp[k] = save;
				}else {
					tmp = new Integer[9][];
					save = new Integer[2];
					save[0] = i;
					save[1] = j;
					tmp[0] = save;
					hMap.put(board[i][j], tmp);
				}
			}
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(solution.isValidSudoku(board));
	}

}
