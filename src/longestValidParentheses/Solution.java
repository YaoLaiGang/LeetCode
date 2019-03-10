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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses(")()())"));
	}

}
