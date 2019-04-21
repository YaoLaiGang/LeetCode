package nQueens;

import java.util.ArrayList;
import java.util.List;


public class Solution2 {
	private int n;
	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		int col = 0, ld = 0, rd = 0;
		char[][] res = new char[n][n];
		List<List<String>> store = new ArrayList<List<String>>();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				res[i][j] = '.';
			}
		}
//		dfs(col, ld, rd, 0, n);
		dfs(col, ld, rd, 0, res, store);
		return store;
    }
	public void dfs(int col, int ld, int rd, int now, char[][] res, List<List<String>> store){
		if(now==n){
			System.out.println("yes");
			ArrayList<String> arr = new ArrayList<>();
			for (char[] cs : res) {
				arr.add(String.valueOf(cs));
			}
			store.add(arr);
			return;
		}
		washrd(rd, n);
		int place = ~(col|ld|rd); //当前能放置的位置
		for(int i=n-1; i>=0; --i){
			if(valueAtBit(place, i)){
				res[now][i] = 'Q';
				ld = set1AtBit(ld, i);
				rd = set1AtBit(rd, i);
				col = set1AtBit(col, i);
				dfs(col, ld>>1, rd<<1, now+1, res, store);
				col = set0AtBit(col, i);
				rd = set0AtBit(rd, i);
				ld = set0AtBit(ld, i);
				res[now][i] = '.';
			}
		}
	}
	public int washrd(int num, int n) {
		return num & (int)(Math.pow(2, n)-1);
	}
	public int set0AtBit(int num, int bit) {
		int mask = ~(1 << bit);//000100
	    return (num & (mask));//111011
	}
	public int set1AtBit(int num, int bit) {
		return (num | (1 << bit));
	}
	public boolean valueAtBit(int num, int bit) {
		return ((num & (1 << bit))!=0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 solution = new Solution2();
		List<List<String>> res = solution.solveNQueens(5);
		for (List<String> list : res) {
			for (String string : list) {
				System.out.println(string);
			}
			System.out.println();
		}
	}

}
