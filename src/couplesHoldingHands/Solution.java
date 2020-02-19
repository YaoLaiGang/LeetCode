package couplesHoldingHands;

import java.util.ArrayList;

public class Solution {
     /*
     * 情侣配对问题，这个问题就是说01一对，12一对，23一对这样以此类推，开始时情侣是随机做座位
     * 然后问你交换几次才能让有情人终成相邻座位
     * 实在没头绪就举个例子：
     * [3,1,4,0,2,5]
     * -> 1和3不配对，所以1和2交换一次：
     * [3,2,4,0,1,5]
     * -> 4和0不配对，所以5和0交换一次：
     * [3,2,4,5,1,0]
     * 也就是交换了两次，这就是最快的交换方法，别问，问就是贪心法。
     * */
     public int minSwapsCouples(int[] row) {
         ArrayList<Integer> rows = new ArrayList<>();
         int n = 0;
         for (int human :
                 row) {
             rows.add(human);
         }
         for (int i = 1; i < row.length; i+=2) {
             int find= rows.get(i-1)^1;
             if (find==rows.get(i)) continue;
             else{
                 int exchange = rows.indexOf(find);
                 rows.set(exchange, rows.get(i));
                 rows.set(i, find);
                 ++n;
             }
         }
         return n;
     }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {3,2,0,1};
        System.out.println(solution.minSwapsCouples(input));
    }
}
