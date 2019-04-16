package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
/*
 * 给字符串分组，这里的字符串是打乱顺序的
 * 
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
思路：每次取一个，跟剩下的对比
其次哈希函数或许是个好思路
 * */
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashSet<String> unique = new HashSet<>();
        String[] order = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
			order[i] = getOrder(strs[i])+i;
		}
        int num = 0; // 记录第几类
        Arrays.sort(order);
        System.out.println(Arrays.toString(order));
        // 初始化
        res.add(new ArrayList<String>());
        int[] tmp = getIndex(order[0]);
        res.get(num).add(strs[tmp[0]]);
        String pre=order[0].substring(0, order[0].length()-tmp[1]); // 记录前一个
        for(int i =1; i<order.length; ++i){
        	tmp = getIndex(order[i]);
        	String code = order[i].substring(0, order[i].length()-tmp[1]);
        	
    		if(code.equals(pre)){
    			res.get(num).add(strs[tmp[0]]);
    		}else {
				num++;
				res.add(new ArrayList<String>());
				res.get(num).add(strs[tmp[0]]);
			}	
        	pre = code;
        }
        return res;
    }
	public int[] getIndex(String str) {
		int[] res = {0,0};
		for(int i = str.length()-1; i>=0; --i){
			if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
				res[0] += (str.charAt(i)-'0')*Math.pow(10, res[1]++);
			}
			else {
				return res;
			}
		}
		return res;
	}
	public String getOrder(String str){
		StringBuilder sBuilder = new StringBuilder();
		char[] charStr = str.toCharArray();
		Arrays.sort(charStr);
		for (char c : charStr) {
			sBuilder.append(c);
		}
		return sBuilder.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] strings = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
		List<List<String>> res = solution.groupAnagrams(strings);
		for (List<String> list : res) {
			System.out.println(list);
		}
	}

}
