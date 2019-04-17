package powXN;

public class Solution {
/*
 * 实现pow(x,n),连乘是不可能连乘的，连乘还是太naive了，肯定会超时
 * 使用二分法来解
 *  
1，当b为偶数时，a^b可以转为a^2的b/2次方。
2，当b为奇数时，a^b可以转为a^2的b/2次方，再乘以a
 * */
	public double myPow(double x, int n) {
		int m = Math.abs(n);
		double res = getPow(x, m);
        return n>=0?res:1/res;
    }
	public double getPow(double x, int n) {
		if(n==0) return 1;
		if (n==1) return x;
		if(n%2==0) return getPow(x*x, n/2);
        else return getPow(x*x, n/2)*x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		double res = solution.myPow(2,2342342);
		System.out.println(res);
	}

}
