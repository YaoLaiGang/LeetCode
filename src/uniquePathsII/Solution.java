package uniquePathsII;
/*
* 和Unique path 类似，不过这里m*n的格子里存在障碍物
* 那么我们在动态规划的时候，就应该考虑存在障碍物的情况,障碍物应当被忽略，且障碍物不能被更新
* */

import java.util.Arrays;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        初始化，如果存在1的障碍替换为-1，以方便计算
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if (i==0&&j==0){
                    obstacleGrid[0][0] = 1;
                }else if(i==0&&j!=0){
                    obstacleGrid[i][j] = obstacleGrid[0][j-1]==-1?-1:1;
                }else if(i!=0&&j==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]==-1?-1:1;
                }
            }
        }
        //开始计算路径
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j]==-1) continue; //障碍物
                obstacleGrid[i][j] = (obstacleGrid[i][j-1]==-1?0:obstacleGrid[i][j-1])+(obstacleGrid[i-1][j]==-1?0:obstacleGrid[i-1][j]);
            }
        }
        // 打印结果
        for (int[] ele :
                obstacleGrid) {
            System.out.println(Arrays.toString(ele));
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==-1?0:obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = {{0,1,0},{1,1,0},{0,0,0}};
        solution.uniquePathsWithObstacles(input);
    }
}
