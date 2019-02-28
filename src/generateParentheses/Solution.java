package generateParentheses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Solution {
/**
 * 个N对括号，求出所有能匹配的括号的组合
 * */
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		generateParenthesis(2*n, res, "", n, 0, 0);
		return res;
    }
	public static void generateParenthesis(int n, List<String> res, String str, int max, int left, int right) {
		System.out.println(n);
		if(n==0){
			if(valid(str.toCharArray())) res.add(str);
			return;
		}else{
			if(left<max) generateParenthesis(n-1, res, str+"(", max, left+1, right);// 左子树
			if(right<max) generateParenthesis(n-1, res, str+")", max, left, right+1);// 右子树
		}
    }
	public static boolean valid(char[] current) {
	        int balance = 0;
	        for (char c: current) {
	            if (c == '(') balance++;
	            else balance--;
	            if (balance < 0) return false;
	        }
	        return (balance == 0);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParenthesis(2));
		
	}

}
