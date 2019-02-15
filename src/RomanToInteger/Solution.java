package RomanToInteger;

public class Solution {
/**
 * @author peter
 * @since 2019年02月14日17:45:29
 * 将罗马字符装换成数字
 * 逐个转化成对应的数字放入数组，遍历数组
 * 若与后面元素构成降序，加入结果中
 * 否则，将后面的元素减去当前元素加入结果中，下标+1递增
 * */
	public static int romanToInt(String s) {
		char[] ch = new char[s.length()];
		int[] num = new int[ch.length];
		int res=0;
		ch = s.toCharArray();
		for(int i = 0; i<ch.length; ++i){
			switch (ch[i]) {
			case 'I': num[i] = 1; break;
			case 'V': num[i] = 5; break;
			case 'X': num[i] = 10; break;
			case 'L': num[i] = 50; break;
			case 'C': num[i] = 100; break;
			case 'D': num[i] = 500; break;
			case 'M': num[i] = 1000; break;
			default:
				return -1;
			}
		}
		for(int i=0; i<num.length; ++i){
			if (i+1==num.length || num[i]>=num[i+1]) {
				res+= num[i];
			}else {
				res += num[i+1]-num[i];
				++i;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));
	}

}
