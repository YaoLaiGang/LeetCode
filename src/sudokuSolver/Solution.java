package sudokuSolver;

public class Solution {
/**
 * 解数独，应该使用回溯法来解决这个问题
 * */
//	public char[][] board;
	private int flag = 0;
	public void solveSudoku(char[][] board) {
		dfs(0, board);
    }
	public void dfs(int n, char[][] board){
		//填第N个空
		if(n == 81){
			flag=1;
			return; // 找到一个正确解
		} 
		int i = n/9, j = n%9;
		if(board[i][j]!='.'){//当前格子不需要填数字
			dfs(n+1, board);
			return;
		}
		for(char ch = '1'; ch<='9'; ch++){
			board[i][j] = ch;
			if(isValid(i, j, board)) dfs(n+1, board);
			if(flag==1) return;
		}
		//没有解， 回溯
		board[i][j] = '.';
	}
	public boolean isValid(int i, int j, char[][] board){
		char n = board[i][j];
        int[] query = {0,0,0,3,3,3,6,6,6};
        int t, u;
        for (t = 0; t < 9; t++)
        {
            if ((t != i && board[t][j] == n) || (t != j && board[i][t] == n))
                return false;
        }

        for (t = query[i]; t < query[i] + 3; t++)
        {
            for (u = query[j]; u < query[j] + 3; u++)
            {
                if ((t != i || u != j) && board[t][u] == n)
                    return false;
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
		solution.solveSudoku(board);
		for(int i = 0; i<9; ++i){
			for(int j=0; j<9; ++j){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}
