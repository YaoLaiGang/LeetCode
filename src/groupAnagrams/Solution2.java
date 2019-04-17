package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
/*
 * solution那种类似hash的方法有些复杂，写起来也浪费时间
 * 这是第二种思路：
 * 使用 HashMap 和sort函数来解决
 * 具体说来：
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 我们可以构建这样一个HashMap
 * {
 * "ate":{"eat","tea","ate"}
 * "ant":{"tan","nat"}
 * "abt":{"bat"}
 * }
 * 每个元素比较的时候，都是sort之后判定等于哪个key
 * 总之是一个good idea
 * */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<>();
		for (String string : strs) {
			char[] str = string.toCharArray();
			Arrays.sort(str);
			String key = String.valueOf(str);
//			if(map.containsKey(key)){//存在key，直接插入List
//				map.get(key).add(string);
//			}else{//不存在key，新建一个键值对用来收集相同的String
//				map.put(key, new ArrayList<String>());
//				map.get(key).add(string);
//			}
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(string);
		}
		for (List<String> list : map.values()) {
			res.add(list);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 solution = new Solution2();
		String[] strings = {"c","c"};
		List<List<String>> res = solution.groupAnagrams(strings);
		for (List<String> list : res) {
			System.out.println(list);
		}
	}

}
