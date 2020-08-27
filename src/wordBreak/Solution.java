package wordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    /*
    * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    * 拆分时可以重复使用字典中的单词。
    * 思路：使用DFS将s递归二分，递归判定左右子串拆分后能否由wordDict组成
    * */
    String s;
    HashSet<String> words = new HashSet<>();
    Boolean[][] memory;
    public boolean dfs(int l, int r){
        if (memory[l][r]!=null) return memory[l][r];
        else{
            if (words.contains(s.substring(l, r+1))) {
                memory[l][r] = true;
                return true;
            }else {
                memory[l][r] = false;
            }
        }
        for (int i = l; i<r; i++) {
            if (dfs(l, i) && dfs(i+1, r)) return true;
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0) return false;
        this.s = s;
        memory = new Boolean[s.length()][s.length()];
        words.addAll(wordDict);
        return dfs(0, s.length()-1);
    }

    public static void main(String[] args) {
        String s = "applepenapplepen";
        String[] words = {"apple", "pen"};
        List<String> wordDict = new ArrayList<String>(Arrays.asList(words));
        System.out.println((new Solution()).wordBreak(s, wordDict));
    }
}
