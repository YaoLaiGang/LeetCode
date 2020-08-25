package substringwithConcatenationofAllWords;

import java.util.*;

public class Solution {
	/*
	* 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
	* 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
	* 思路：
	* 使用HaspMap来记录words中每个单词出现的次数
	* 遍历字符串，这里每次遍历其长度为n*len个长度[i, i+n*len-1]，如果长度不足[i+n*len-1>=s.length()]，直接停止判定
	* 对区间内的字符串按照长度为len进行遍历，并再开辟一个HaspMap将出现次数进行记录，如果超过words中的次数或者没有在words中出现，直接停止本次判断
	* */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s.length()==0||words.length==0) return res;
		int len = words[0].length(), n = words.length, maxIndex = s.length()-n*len+1;
		HashMap<String, Integer> wordNum = new HashMap<>(), wordCount;
		for (String word :
				words) {
			if (wordNum.containsKey(word)) wordNum.put(word, wordNum.get(word) + 1);
			else wordNum.put(word, 1);
		}
		for (int i = 0; i < maxIndex; i++) {
			wordCount = new HashMap<>();
			int j;
			for (j = i; j < i+n*len; j+=len) {
				String ts = s.substring(j, j+len);
				if (!wordNum.containsKey(ts)) break; // words中不存在的单词
				if (wordCount.containsKey(ts)){
					int freq = wordCount.get(ts)+1;
					if (freq>wordNum.get(ts)) break; // 超过words限制
					wordCount.put(ts, freq);
				}else {
					wordCount.put(ts, 1);
				}
			}
			if (j==i+n*len) res.add(i);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "";
		String[] words = {};
		System.out.println(solution.findSubstring(s, words));
	}

}
