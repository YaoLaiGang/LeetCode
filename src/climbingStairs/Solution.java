package climbingStairs;
/*
* 爬梯子，有一个高度为n的梯子，你每次只能向上爬1步或者两步
* 求出一共有几种爬法？
* Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

思路，类似于jumpGame， 使用计数型DP可解
* */
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n>1) dp[1] = 2;
        if (n>2){
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
