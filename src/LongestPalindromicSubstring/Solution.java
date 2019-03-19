package LongestPalindromicSubstring;

import java.util.Arrays;

/**
 * @author peter
 * @since 2018年01月09日14:34:40
 * 寻找一个字符串中的最长回文子串问题
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 思路如下:
 * 1.暴力破解 Brute_Force
 * 访问每一个子串并判定其是否为回文,复杂度为o(n^3)
 * 2.马拉车(Manacher)算法,该算法复杂度为o(n^2)
 * 该算法以计算回文半径为核心,其中利用回文的对称性来节省时间复杂度
 * 而求回文半径时可以利用之前的回文半径方法节省时间
 * 引入一个辅助变量MaxRight，表示当前访问到的所有回文子串，所能触及的最右一个字符的位置。
 * 另外还要记录下MaxRight对应的回文串的对称轴所在的位置，记为pos
 * 假设当前所求回文半径的子中心为i,那么i一定在pos的右侧,下面讨论i的MaxRight的关系
 * 1 i在MaxRight的左侧
 * 这样的话,i的左侧一定有和它关于pos对称的j[2*pos-i]
 * 故 r(i)>=r(j)
 * 而r的半径最大不能超过MaxRight,超过的话就得继续判定右方的字符是否对称
 * 故:
 * r(i)=min(RL[2*pos-i], MaxRight-i)
 * 在根据这个继续扩展,直到半径不同
 * 同时不断更新pos和MaxRight
 * 2. i在MaxRight的右侧
 * 此时i的半径已经无法利用前面的结果
 * 重新判定即可
 * */
public class Solution {
    public static String longestPalindrome(String s) {
//    	数组间隔处放#以解决偶字符串对称问题
    	StringBuilder sb = new StringBuilder(s);
    	for (int i = 0; i < sb.length(); i++) {
			sb.insert(i, '#');
			i++;
		}
    	sb.append('#');
    	s=sb.toString();
    	int i=0,pos=0,maxRight=0,tmp,len=s.length(),maxLen=0,maxPos=0;
    	int[] r = new int[len];
    	Arrays.fill(r, 0);
    	while(i<len){
    		tmp=0;
    		//情况1,直接求半径
    		if(i>maxRight){
    			while(i+tmp<len&&i-tmp>=0&&(s.charAt(i+tmp)==s.charAt(i-tmp))){
    				tmp++;
    			}
    			r[i]=tmp-1;
//    			肯定超过了MaxRight直接更新即可
    			pos=i;
    			maxRight=i+tmp-1;
    		}
    		else{//情况二,在两者之间
    			tmp=maxRight-i<r[2*pos-i]?maxRight-i:r[2*pos-i];
    			while(i+tmp<len&&i-tmp>=0&&(s.charAt(i+tmp)==s.charAt(i-tmp))){
    				tmp++;
    			}
    			r[i]=tmp-1;
//    			此处需要判定
    			if(i+tmp-1>maxRight){
    				maxRight=i+tmp-1;
    				pos=i;
    			}
    		}
    		System.out.println(tmp);
    		if(maxLen<tmp-1){
    			maxPos=i;
    			maxLen=tmp-1;
    		}
    		i++;
    	}
//    	获得最大回文串
    	s=s.substring(maxPos-maxLen, maxPos+maxLen+1);
//    	System.out.println(maxPos+":"+maxLen);
//    	去除"#"
    	sb = new StringBuilder(s);
    	for(i=0;i<sb.length();i++){
    		if(sb.charAt(i)=='#'){
    			sb.deleteCharAt(i);
    			i--;
    		}
    	}
    	
        return sb.toString();
    }
    public static String longestPalindrome2(String s){
/*使用DP来解这个问题
 * 设DP[i][j]表示从i-j能否组成回文串
 * 如果DP[i][j] == 1 那么DP[i+1][j-1]一定为1
 * 因此DP[i][j]=
 * ① 若s[i]==s[j] =>DP[i+1][j-1]
 * ② 否则为0
 * 计算顺序：从下到上，从左到右（j>=i）
 * */    
    	int len = s.length(), max = 1, maxi=0;
    	if(len==0) return "";
    	if(len==1) return s;
    	int[][] dp = new int[len][len];
    	for(int i=0; i<len; ++i){
    		for(int j=0; j<len; ++j){
    			dp[i][j] = 1;
    		}
    	}
    	for(int i=len-1; i>=0; --i){
    		for(int j=i+1;j<len;j++){
    			if(s.charAt(i)==s.charAt(j)){
    				dp[i][j] = dp[i+1][j-1];
    				if(dp[i][j]==1&&max<j-i+1){
    					max = j-i+1;
    					maxi = i;
    				}
    			}else{
    				dp[i][j]=0;
    			}
    		}
    	}
    	return s.substring(maxi, maxi+max);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(longestPalindrome("cbbd"));
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome2("babadada"));
	}

}
