package distinctSubsequences;

import java.util.Arrays;

public class Solution {
    /*
    * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
    * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
    * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
    * 思路：字符串子序列匹配 => 动态规划 => 二维DP数组+状态转移方程
    * DP[i][j] 表示 ： S的前j个字符有DP[i][j]种方式来表示T的前i个字符
    * 状态转移方程： DP[i][j] = S[j-1] == T[i-1] ? DP[i][j-1] + DP[i-1][j-1] : DP[i][j-1]
    * */
    public int numDistinct(String s, String t) {
        int[][] DP = new int[t.length()+1][s.length()+1];
        // 边界初始化（带有空字符串的情况）
        DP[0][0] = 1;
        for (int i = 1; i < DP.length; i++) {
            DP[i][0] = 0;
        }
        for (int i = 1; i < DP[0].length; i++) {
            DP[0][i] = 1;
        }
        for (int i = 1; i < DP.length; i++) {
            for (int j = i; j < DP[0].length; j++) {
                DP[i][j] = s.charAt(j-1) == t.charAt(i-1) ? DP[i][j-1] + DP[i-1][j-1] : DP[i][j-1];
            }
        }
        for (int[] arr :
                DP) {
            System.out.println(Arrays.toString(arr));
        }
        return DP[t.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).numDistinct("babgbag","bag"));
    }
}
