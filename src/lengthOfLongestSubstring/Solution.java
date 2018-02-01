package lengthOfLongestSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 老生常谈的问题了
 * 求一个字符串最长不重复子串长度
 * 从前向后依次放入set中,放入之前查重
 * 若存在则tmp=0,否则tem++
 * 设置一个max
 * 但是此方法时间太长,虽然可行但时间复杂度太长,需要选择一个占用时间更少的方法
 *遍历该字符串
 *使用map记录出现的位置
 *若存在,则其距离为本次位置与上次位置之差,并更新位置
 *若不存在,存储位置即可
 * */
public class Solution {
	public static int lengthOfLongestSubstring(String s) 
	{
	      	int n = s.length();
	        Set<Character> set = new HashSet<>();
	        int res = 0, i = 0, j = 0;
	        while (i < n && j < n) {
	            if (set.contains(s.charAt(j)))
	            {
	            	 set.remove(s.charAt(i));//重复下删除重复元素,i记录重复位置的下一位置,表示从i开始回溯
	            	 i++;
	            }
	            else //不重复
	            {
	                res = res>(j-i)?res:(j-i);
	                set.add(s.charAt(j));
	                j++;
	            }
	        }
	        return res;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
}
