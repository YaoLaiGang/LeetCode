package lengthofLastWord;

public class Solution {
/*
* 这是一道简单题，但是从提交的情况来看不是很乐观
* 这道题给了一个字符串s, 求出最后一个单词的长度，注意一些特例
* Input: "Hello World"
* Output: 5
* */
    public int lengthOfLastWord(String s) {
        int res = 0, n = s.length(), i=n-1;
        while (i>=0&&s.charAt(i)==' ') --i; // 去除末尾空格
        for (; i >= 0; i--) {
            if (s.charAt(i)==' ') break;
            ++res;
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(""));
    }
}
