package coinChange2;

public class Solution {
/*
 * 和coinChange类似，不过这次是计数，不是求最少需要多少
 * 思路：使用动态规划来解本问题
 * 设DP[i]表示凑够i元所使用的组合数
 * DP[i] += DP[i-coin[j]] 
 * */
	public int change(int amount, int[] coins) {
        int[] res = new int[amount+1];
        res[0] = 1;
        for (int i : coins) {
			for(int j = i; j<=amount; ++j){
				res[j] += res[j-i];
			}
		}
        for (int i : res) {
			System.out.print(i+" ");
		}
        System.out.println();
        return res[amount];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 3;
		int[] coins = {2};
		Solution solution = new Solution();
		System.out.println(solution.change(amount, coins));
	}

}
