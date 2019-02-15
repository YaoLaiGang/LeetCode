package UniquePath;

public class UniquePath {
/**
 * 给一个M*N 的格子，机器人在格子的左上角
 * 机器人只能向下或向右移动，问机器人走到右下角有多少种走法？
 * 记数型动态规划问题
 * F[m,n] = F[m-1,n]+F[m,n-1]
 * */
	public static int uniquePaht(int m, int n){
		int[][] map = new int[m][n];
		//初始化
		map[0][0] = 1;
		for (int i = 1; i < m; i++) map[i][0]=1;
		for (int i = 1; i < n; i++) map[0][i]=1;
		for(int i = 1; i<m; ++i){
			for (int j = 1; j < n; ++j) {
				map[i][j] = map[i-1][j] + map[i][j-1];
			}
		}
		return map[m-1][n-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaht(7, 3));
	}

}
