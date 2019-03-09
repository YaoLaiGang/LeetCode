package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Solution {
	//顾名思义，求无重复最长子串的长度,
	//	本解法是动态规划解法，其中F[i]表示[0-i]内最长不重复子串的长度
	//	时间复杂度为O(n^2)
	public static int lengthOfLongestSubstring(String s) {
		if (s.isEmpty()) return 0;
		int[] F = new int[s.length()];
		char[] sc = s.toCharArray();
		int max = 1;
		F[0] = 1;
		for(int i = 1; i<F.length; ++i){
			int j;
			for (j = 1; j <= F[i-1]; j++) {
				if (sc[i-j]==sc[i]) {
					break;
				}
			}
			F[i] = j;
			max = max > F[i] ? max : F[i];
		}
		return max;
	}
	public static int lengthOfLongestSubstring2(String s) {
//		本题的第二种解法，复杂度为O(n)，其思想是维护一个滑动窗口
/**
 * 每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。
 * 同样是维护一个HashSet, 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，
 * 如果发现重复字符，则说明当前窗口中的串已经不满足要求，
 * 继续移动有窗口不可能得到更好的结果，此时移动左窗口，直到不再有重复字符为止，
 * 中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。
 * 因为左窗口和右窗口都只向前，所以两个窗口都对每个元素访问不超过一遍，
 * */
		char[] str = s.toCharArray();
		HashSet<Character> unique = new HashSet<Character>();
		int left = 0,right = 0, max = 0;
		while(right<str.length){
			if(!unique.contains(str[right])){
				unique.add(str[right]);
				right++;
			}else{
				max = max>right-left? max : right-left;
				while(str[left]!=str[right]) {
					unique.remove(str[left]);
					left++;
				}
				if(left!=right) left++;
				unique.remove(str[right]);
			}
		}
		max = max>right-left? max : right-left;
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tmmzuxt";
		System.out.println("res"+lengthOfLongestSubstring2(s));
		
	}

}
