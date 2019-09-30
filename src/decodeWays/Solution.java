package decodeWays;


public class Solution {
    /*
    * 现在对字符串有一套编码方案:
    * 'A' -> 1
    * 'B' -> 2
    *   ...
    * 'Z' -> 26
    * 解码是有规律的，所以我们可以尝试动态规划。假设数组dp[i]表示从头到字符串的第i位，
    * 一共有多少种解码方法的话，那么如果字符串的第i-1位和第i位能组成一个10到26的数字，
    * 说明我们是在第i-2位的解码方法上继续解码。如果字符串的第i-1位和第i位不能组成有效二位数字，
    * 而且第i位不是0的话，说明我们是在第i-1位的解码方法上继续解码。
    * 所以，如果两个条件都符合，则dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]。
    * */
    public int numDecodings(String s) {
        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length() + 1];
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("1010"));
    }
}
