package countandSay;

public class Solution {
/**
 * 1
 * 1个1 11
 * 2个1 21
 * 1个2，1个1 1211
 * 1个1 1个2 2个1 111221
 * 3个1 2个2 1个1 312211
 * 依次类推
 * */
	private int n;
	public String countAndSay(int n) {
		if(n==1) return "1";
		this.n = n-1;
		return dfs("1", 1);
    }
	public String dfs(String input, int i) {
		int len = input.length();
		StringBuilder sb = new StringBuilder();
		int j = 0, k;
		while(j<len){
			k=j+1;
			while(k<len&&input.charAt(j)==input.charAt(k)) k++;
			sb.append(""+(k-j)+input.charAt(j));
			j = k;
		}
		if(i==n) return sb.toString();
		return dfs(sb.toString(), i+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.countAndSay(4));
	}

}
