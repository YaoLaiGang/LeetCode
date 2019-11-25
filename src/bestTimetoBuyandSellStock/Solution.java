package bestTimetoBuyandSellStock;

public class Solution {
//    给一个数组，从前往后表示每一天的股价，选择一天买股票一天卖股票使得其利润最大，求出最大利润
//    遍历数组，只要减去前面的最小值就是当前最大利润
    public int maxProfit(int[] prices) {
        if (prices.length==0) return 0;
        int maxPro = Integer.MIN_VALUE, preMin = prices[0];
        for (int price : prices) {
            if (price < preMin) {
                preMin = price;
                continue;
            }
            maxPro = Math.max(maxPro, price - preMin);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] input = {7,6,4,3,1};
        System.out.println((new Solution()).maxProfit(input));
    }
}
