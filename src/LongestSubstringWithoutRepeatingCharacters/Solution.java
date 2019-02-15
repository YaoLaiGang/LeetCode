package LongestSubstringWithoutRepeatingCharacters;

public class Solution {
	//顾名思义，求无重复最长子串的长度
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabccdd";
		System.out.println("res"+lengthOfLongestSubstring(s));
		
	}

}
