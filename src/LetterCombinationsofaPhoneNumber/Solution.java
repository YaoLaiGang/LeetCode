package LetterCombinationsofaPhoneNumber;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
/**
 * 按键手机中有英文字母，现在给两个按键（数字号），求出所有可能的英文字母组合
 * */	
	public static List<String> letterCombinations(String digits) {
		digits = digits.replace("1", "");//去除无用的1
        digits = digits.replace("0", "");
        List<String> res = new ArrayList<String>();
        if (digits.isEmpty()) return res;
        String[][] set = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        int n = digits.length();
        for (String strings : set[digits.charAt(0) - '0' - 2]) {
			res.add(strings);
		}
        for (int i = 1; i < n; i++) {
			int j = digits.charAt(i) - '0' - 2;
			int m = res.size();
			for (int l = 0; l < set[j].length; ++l) {
				for (int k = 0; k < m; k++) {
					if (l==0) {
						res.set(k, res.get(k)+set[j][0]);
					}else {
						res.add(res.get(k).substring(0, res.get(k).length()-1)+set[j][l]);
					}
				}
			}
		}
        
        Collections.sort(res);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("2"));
	}

}
