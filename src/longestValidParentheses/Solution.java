package longestValidParentheses;

import java.util.Stack;

public class Solution {
	public static int longestValidParentheses(String s) {
/**
 * 1.栈的解法，栈里不放括号，放坐标,初始栈中放一个-1
 * 当碰到匹配的时候，只需要弹出栈，由于记录的是下标，只需做减法，
 * 即可得到目前的最大匹配长度，并且栈中记录了所有匹配之前的坐标，不会漏接
 * */		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		char[] str = s.toCharArray();
		int maxLength=0, lenght;
		for(int i = 0; i<str.length; ++i){
			if(str[i]==')'&&stack.peek()!=-1&&str[stack.peek()]=='('){
				stack.pop();
				lenght = i - stack.peek();
				maxLength = maxLength>lenght?maxLength:lenght;
			}else {
				stack.push(i);
			}
		}
		return maxLength;
    }
	public static int longestValidParentheses2(String s) {
/**
 * 动态规划解法，longest[i]， 表示s[i]能匹配的最大长度
 * 若s[i]==( => longest[i] = 0
 * 若s[i]==)
  	1.s[i sub longest[i sub 1] sub 1] == '('      ((()))型
  	2.()() 型 加上 longest[i sub longest[i sub 1] sub 2]
  故转移方程： longest[i] = longest[i sub-1] + 2 + longest[i sub-longest[i sub-1] sub-2]
  这里要保证i sub longest[i sub 1] sub 1>=0
  而i sub longest[i sub 1] sub 2 是否为0 只需要判断一下即可
 * */		
		int max = 0, tmp;
		char[] str = s.toCharArray();
		int longest[] = new int[str.length];
		longest[0] = 0;
		for(int i=1;i<longest.length;++i){
			if(str[i]=='(') longest[i]=0;
			else {
				tmp = i - longest[i-1] -1;
				if(tmp>=0&&str[tmp]=='('){
					longest[i] = longest[i-1]+2+(tmp-1>=0?longest[tmp-1]:0);
				}else {
					longest[i] = 0;
				}
			}
			max = max>longest[i]?max:longest[i];
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses2(")()())"));
	}

}
