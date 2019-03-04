package implementStrstr;

public class Solution {
/**
 * 经典问题，字符串匹配问题
 * 首先想到的是KMP算法，这是解决字符串匹配问题最经典的解法
 * */
	public static void getNext(char[] t, int[] next) {
		
		next[0] = -1;
		int i = 0, j = -1;
		while(i < t.length-1){
			if(j==-1||t[i]==t[j]){
				++i;
				++j;
				next[i] = j;
			}
			else{
				j = next[j];
			}
		}
	}
	public static int kmp(String t, String p){
		int i = 0, j=0;
		char[] tc = t.toCharArray(), pc = p.toCharArray();
		if(pc.length==0) return 0;
		if(tc.length<pc.length|| tc.length==0|| pc.length==0) return -1;
		int[] next = new int[pc.length];
		getNext(pc, next);
		while(i<tc.length&&j<pc.length) {
			if(j==-1||tc[i]==pc[j]){
				i++;
				j++;
			}
			else {
				j = next[j];
			}
		}
		if(j == pc.length){
			return i - j;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(kmp("mississippi","issip"));
	}

}
