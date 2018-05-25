package ReverseInteger;

public class Solution {
	public static void main(String[] args) {
		System.out.println("res="+reverse(123));
		
	}
    public static long reverse(int x) {
        long b = x,c=0;
        System.out.println(b);
        while(b!=0){
        	c*=10;
        	c += b%10;
        	if(c > Integer.MAX_VALUE|| c < Integer.MIN_VALUE){
        		return 0;
        	}
        	System.out.println("c="+c);
        	b /=10;
        }
        return c;
    }
}