package multiplyStrings;

public class Solution {
/*
 * 给两个字符串整数，返回这两个整数字符串相乘后的结果
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 不能使用字符串转化函数，不能使用BigInteger类
 * */
	public String multiply(String num1, String num2) {
/*
 * 思路：对于大整数乘法，用最传统的
 * */   
//		两个整数相乘的长度不会超过两个整数长度之和
		int[] res = new int[num1.length()+num2.length()];
		String small = num1.length()<num2.length()? num1:num2;
		String big = num1.length()<num2.length()? num2:num1;
		for(int i=0; i<small.length(); ++i){
			for (int j = 0; j <big.length(); ++j) {
				res[i+j+1]+= (small.charAt(i)-'0')*(big.charAt(j)-'0');
			}
		}
//		进位处理,从右向左进位
		for(int i=res.length-1; i>=1; --i){
			if(res[i]<10) continue;
			res[i-1] += res[i]/10;
			res[i] = res[i]%10;
		}
		StringBuilder sBuilder = new StringBuilder();
		int i = 0;
		// 防止前面出现多个0
		while(i<res.length-1&&res[i]==0) i++;
		for(; i<res.length; ++i){
			sBuilder.append(res[i]);
		}
		return sBuilder.toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.multiply("9133", "0"));
	}

}
