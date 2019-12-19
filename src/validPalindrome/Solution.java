package validPalindrome;
/*
*给一个字符串，判断该字符串是否是回文串，只考虑字母和数字，其余字符不考虑，不考虑大小写
* */
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        char left, right;
        while (i<j){
            left = s.charAt(i);
            right = s.charAt(j);
            while (i<j&&!Character.isLetterOrDigit(left)){
                left = s.charAt(++i);
            }
            while (i<j&&!Character.isLetterOrDigit(right)){
                right = s.charAt(--j);
            }
            if (Character.toLowerCase(left)!=Character.toLowerCase(right)) return false;
            ++i;
            --j;
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isPalindrome("0P"));
    }
}
