package PalindromeNumber;
/**
 * 回文数的判断，小菜一碟，某年试题出现过回文完数
 * */
public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome(0));
	}
    public static boolean isPalindrome(int x) {
    	if(x<0){
    		return false;
    	}
    	int temp = x,px = 0;
    	while(temp != 0){
    		px =px*10 + temp%10;
    		temp/=10;
    	}
    	if(px == x){
    		return true;
    	}
    		return false;
    }
}
