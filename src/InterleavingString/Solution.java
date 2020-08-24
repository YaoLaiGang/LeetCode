package InterleavingString;

import java.util.Arrays;

public class Solution {
    /*
    * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
    * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    * 输出：true
    *
    * 思路：一般来说字符串子序列或者匹配问题需要用到动态规划，且一般为二维DP数组
    * DP[i][j]: 表示s1的前i个元素和s2的前j个元素能否交错为第s3的前i+j个元素
    * DP[i][j] = [ DP[i-1][j] && (s1[i-1] == s3[i+j-1]) ] || [ DP[i][j-1] && (s2[j-1] == s3[i+j-1]) ]
    * DP[i-1][j]表示： s1的前i-1个元素 + s2的j个元素 => s3的i+j-1个元素匹配 => 现在查看s1的第i个元素和s3的第i+j个元素能否匹配
    * DP[i][j-1]表示： s1的前i个元素 + s2的j-1个元素 => s3的i+j-1个元素匹配 => 现在查看s2的第j个元素和s3的第i+j个元素能否匹配
    * */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length()) return false;
        if (s1.length()==0) return s3.equals(s2);
        if (s2.length()==0) return s3.equals(s1);
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        // 边界初始化
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1)) dp[i][0] = true;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1)) dp[0][j] = true;
        }
        // 从左到右，从上到下访问给dp填空
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
