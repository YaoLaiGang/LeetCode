package LongestCommonPrefix;

import java.util.Arrays;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length==0) return "";
		if (strs.length==1) return strs[0];
		char[][] ch = new char[strs.length][];
		int bound = Integer.MAX_VALUE;
		StringBuilder sBuilder = new StringBuilder("");
		for(int i =0;i<strs.length;++i){
			ch[i] = strs[i].toCharArray();
			bound = bound>ch[i].length? ch[i].length: bound;
		}
		for(int i = 0; i<bound; ++i){
			char pre = ch[0][i];
			for (char[] cs : ch) {
				if(cs[i]!=pre) return sBuilder.toString();
			}
			sBuilder.append(pre);
		}
		return sBuilder.toString();
	}
	public static String longestCommonPrefix2(String[] strs) {
//		思路二，使用Arrays.sort，进而获取最大数组和最小数组，然后获得这两个数组的最大前缀即可
		if (strs.length==0) return "";
		if (strs.length==1) return strs[0];
		Arrays.sort(strs);
		String min = strs[0], max = strs[strs.length-1];
		int n = min.length()<max.length()? min.length(): max.length(),i;
		for(i=0; i<n ; ++i){
			if (min.charAt(i)!= max.charAt(i)) break;
		}
		return min.substring(0,i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix2(strs));
	}

}
