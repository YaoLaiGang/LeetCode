package validParentheses;

import java.util.Stack;

public class Solution {
/**
 * 符号匹配问题，使用栈即可
 * */
	public static boolean isValid(String s) {
		/**
		 * 1.进左括号，push
		 * 2.进右括号，判断是否匹配，若匹配pop，否则返回error
		 * 3.都进完判断是否为空，如果为空,且数组遍历完毕返回true，否则返回false
		 * */
		char[] ch = s.toCharArray();
		int i;
		if(ch.length==0) return true;
		if (ch.length%2!=0) return false;
		Stack<Character> stack = new Stack<>(); 
		stack.push(ch[0]);
		for(i=1; i<ch.length; ++i){
			if (ch[i]=='('||ch[i]=='['||ch[i]=='{') {
				stack.push(ch[i]);
			}else{
					if(stack.isEmpty()) return false;
					switch (ch[i]) {
					case ')':
						if(stack.peek()=='(') stack.pop();
						else return false;
						break;
					case ']':
						if(stack.peek()=='[') stack.pop();
						else return false;
						break;
					case '}':
						if(stack.peek()=='{') stack.pop();
						else return false;
						break;
					default:
						return false;
					}
			}
		}
		if (stack.isEmpty()&&i==ch.length) return true;
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()))"));
	}

}
