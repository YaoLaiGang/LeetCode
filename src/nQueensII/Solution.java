package nQueensII;


public class Solution {
/*
 * 仍然是N后问题，但是这次N后问题是统计有几个解,全解出来似乎有点麻烦
 * 考虑存储三个能否放置矩阵
 * col 列能否放置 ld 左斜线能否放置 rd 右斜线能否放置
 * 初始时
 * col [0000] ld [0000] rd [0000]
 * 在第一个位置放置后
 * col [1000] ld[1000] rd [1000]
 * 在第二列放置的时候
 * col [1000] ld[0100] rd [0000] 每次ld rd 分别>> 和 <<
 * 三者～(col|ld|rd) 剩下是1的即可放置
 * */
	private int n;
	private int sum;
	public int totalNQueens(int n) {
		this.n = n;
		int col = 0, ld = 0, rd = 0;
//		dfs(col, ld, rd, 0, n);
		dfs(col, ld, rd, 0);
		return sum;
    }
	public void dfs(int col, int ld, int rd, int now){
		if(now==n){
			sum ++;
			return;
		}
		washrd(rd, n);
		int place = ~(col|ld|rd); //当前能放置的位置
		for(int i=n-1; i>=0; --i){
			if(valueAtBit(place, i)){
				ld = set1AtBit(ld, i);
				rd = set1AtBit(rd, i);
				col = set1AtBit(col, i);
				dfs(col, ld>>1, rd<<1, now+1);
				col = set0AtBit(col, i);
				rd = set0AtBit(rd, i);
				ld = set0AtBit(ld, i);
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
		Solution solution = new Solution();
		System.out.println(solution.totalNQueens(5));
	}

}
