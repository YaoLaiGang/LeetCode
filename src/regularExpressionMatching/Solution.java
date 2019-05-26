package regularExpressionMatching;
/*
* 字符匹配问题
* 用p来匹配s. p中可能包含. *
* . 表示匹配任一个单一字符
* * 表示匹配0到多个前一个字符
* 要求p和s匹配
* */
/*Input:
        s = "aa"
        p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".*/
/*Input:
        s = "aa"
        p = "a*"
        Output: true
        Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".*/
/*Input:
        s = "aab"
        p = "c*a*b"
        Output: true
        Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".*/
public class Solution {
//    思路，使用DP，这是一道true false dp问题, dp[i][j] 表示了s前i个元素和p前j个元素的匹配情况
/*
* 分情况讨论
* 1.如果s[i] == p [j] || p[j] == '.'
* 这时候完全就看前面的情况 dp[i][j] = dp[i-1][j-1]
* 2.如果s[i] != p [j]这个也要分情况
* 2.1 如果p[j] == '*' (ba a* ab a*)
*    2.1.1 若 p[j-1] != s[i] && p[j-1] != '.'
*    此时, 由于上一个元素不匹配导致*无法复制，那么*只能让上一个元素清空
*    dp[i][j] = dp[i][j-2]
*    2.1.2 除上面的情况外，即*可以复制上一个元素达到匹配的目的，当然也可以不复制上一个元素
*    dp[i][j] = dp[i][j-2] (上一个元素清空) || dp[i][j-1] (*只代表一个元素) || dp[i-1][j] (代表多个元素，如果在i前面都能和p匹配，那加一个自然也能匹配)
* 2.2 如果p[j] != '*'
*   dp[i][j] = false
* */
    public  boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // s为空, p为空
        dp[0][0] = true;
        // s为空， p不空
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1)=='*' && dp[0][j-2]) dp[0][j] = true;
        }
        //s不空，p空，直接默认false
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') dp[i][j] = dp[i-1][j-1];
                else {
                    if (p.charAt(j-1)=='*'){
                        if (p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.') dp[i][j] = dp[i][j-2];
                        else dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

	public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aab","c*a*b"));
	}
}
