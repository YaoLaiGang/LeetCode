package wordSearch;

public class Solution {
/*
 * 给一个二维矩阵，在矩阵中查找单词，可以上下左右相邻查找
 * 思路：使用递归，因为查找单词的操作都是重复的找某个位置上下左右的格子是否具有下一个单词的位置，这个操作可以使用递归来实现
 * 注意二位矩阵中的每个字母只能使用一次，需要房子字母反复使用的问题
 * **/
	public char[][] board;
	public char[] word;
	public boolean[][] visited;
	 public boolean exist(char[][] board, String word) {
		 if (word.length()==0) return true;
		 if (board.length==0) return false;
		 this.board = board;
		 this.word = word.toCharArray();
		 visited = new boolean[board.length][board[0].length];
		 for(int i = 0; i<board.length; ++i) {
			 for (int j = 0; j<board[0].length; ++j) {
				if(board[i][j]==this.word[0]) {// 开始查找
//					System.out.println("start!"+board[i][j]);
					visited[i][j]= true;
					if (find(i+1, j, 1)||find(i, j+1, 1)||find(i-1, j, 1)||find(i, j-1,1)) return true;
					visited[i][j] = false;
				}
			}
		 }
	     return false; 
	 }
	 public boolean find(int i, int j, int wordIndex) {
		 if(wordIndex==word.length) return true;
		 if(i<0||i>=board.length||j<0||j>=board[0].length||visited[i][j]) return false;
		 boolean res=false;
		 if (board[i][j]==word[wordIndex]) {//下一步搜索
			 visited[i][j]= true;
//			 System.out.println(board[i][j]);
			 res =  find(i+1, j, wordIndex+1)||find(i, j+1, wordIndex+1)||find(i-1, j, wordIndex+1)||find(i, j-1, wordIndex+1);
			 if(!res) visited[i][j]=false;
		 }
		 return res;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABC";
		System.out.println(solution.exist(board, word));
	}

}
