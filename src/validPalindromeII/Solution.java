package validPalindromeII;

public class Solution {
    /*
    * 接上题，判断一个字符串是否是回文串，并允许删除一个字符，如果删除后成为字符串也可以
    * 字符串只存在a-z
    * 仍然是按照之前的方式来进行前后的比较
    * 当遇到第一个不同的字符的时候，考虑删除左边（j--）或者右边(i++)的元素，然后在进行比较
    * */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return isPalindrome(s.substring(i, j))||isPalindrome(s.substring(i+1, j+1));
            i++;
            j--;
        }
        return true;
    }
    private boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while (i<j) if (s.charAt(i++)!=s.charAt(j--)) return false;
        return true;
    }
}
