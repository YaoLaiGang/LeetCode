package regionsCutBySlashes;

public class Solution2 {
    // 将一个方块转化成一个3*3的方块,就可以表示"/""\"" "三种状态,然后对这种图象进行dfs搜索
    int[][] grid_net;
    public int regionsBySlashes(String[] grid){
        int res = 0;
        grid_net = new  int[grid.length*3][grid.length*3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                switch (grid[i].charAt(j)){
                    case '\\':{
                        grid_net[i*3][j*3] = 1;
                        grid_net[i*3+1][j*3+1] = 1;
                        grid_net[i*3+2][j*3+2] = 1;
                        break;
                    }
                    case '/':{
                        grid_net[i*3+2][j*3] = 1;
                        grid_net[i*3+1][j*3+1] = 1;
                        grid_net[i*3][j*3+2] = 1;
                        break;
                    }
                    default:{
                        break;
                    }
                }
            }
        }
        // dfs 遍历该二维数组
        for (int i = 0; i < grid_net.length; i++) {
            for (int j = 0; j < grid_net.length; j++) {
                if (grid_net[i][j]==0){
                    ++res;
                    dfs(i,j);
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j){
        grid_net[i][j] = 1;
        if (i-1>=0 && grid_net[i-1][j]!=1) dfs(i-1,j);
        if (i+1<grid_net.length && grid_net[i+1][j]!=1) dfs(i+1, j);
        if (j-1>=0 && grid_net[i][j-1]!=1) dfs(i, j-1);
        if (j+1<grid_net.length && grid_net[i][j+1]!=1) dfs(i,j+1);
    }

    public static void main(String[] args) {
        String[] grid = {"/"};
        System.out.println((new Solution2()).regionsBySlashes(grid));
    }
}
