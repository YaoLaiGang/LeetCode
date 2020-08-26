package bestTimetoBuyandSellStockIII;

import java.util.Arrays;

public class Solution {
    /*
    * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    * 相对于I，这里限定了交易次数为两次，这里我们先回忆下I中的DP
    * DP[i] ： 从0到i进行一次交易说获得的最大money
    * 状态转移方程： DP[i] = max(DP[i-1], peice[i] - price[min])
    *
    * 那么这个两次交易其实就是将数组一分为二，分别求前后两半段的最大额度然后相加，那么我们的DP应该分为两部分
    * 左侧为LDP[i] 和上述方程一样
    * 右侧为RDP[i]： 表示从i开始到尾部所产生交易的最大值，其状态转移方程为(由于必须是右侧减去左侧，所以是从右向左)
    * DP[i] = max(DP[i+1], price[max] - price[i])
    * 由于i表示两个数字之间原因，LDP和RDP开头多出一位来补0以便于对齐
    * 比如：
    *     7 1 5 3 6 4
    * LDP 0 0 0 4 4 5 5
    * RDP 5 5 3 3 0 0 0
    * ADD 5 5 3 7 4 5 5
    * 我们只需要将两个DP数组对应相加就可以获得以i为分界线的最大交易额，即可以求解
    *
    *
     * */
    public int maxProfit(int[] prices) {
        int res=0;
        int[] LDP = new int[prices.length+1], RDP = new int[prices.length+1];
        int min = 0, max = prices.length-1;
        for (int i = 2, index = 1; i < LDP.length; i++, index++) {
            LDP[i] = Math.max(LDP[i-1], prices[index] - prices[min]);
            min = prices[index] < prices[min] ? index : min;
        }
        for (int i = RDP.length-3, index = prices.length-2; i >= 0; i--, index--) {
            RDP[i] = Math.max(RDP[i+1], prices[max] - prices[index]);
            max = prices[max] > prices[index] ? max : index;
        }
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, LDP[i]+RDP[i]);
        }
//        System.out.println(Arrays.toString(LDP));
//        System.out.println(Arrays.toString(RDP));
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(input));
    }
}
