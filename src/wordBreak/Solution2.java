package wordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
    /*
    * 当然了，我们知道DFS+Memory和DP是好朋友，在DFS+Memory能解决的问题上，DP也可以搞定
    * DP[i] : 表示[0, i]能否被 wordDict拆分
    * DP[i]又可以拆分为两部分, [0, j] [j+1, i] 其中[0, j]就是DP[j] ， 而[j+1, i]直接在字典中查看即可
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] DP = new boolean[s.length()+1];
        HashSet<String> words = new HashSet<>(wordDict);
        DP[0] = true;
        for (int i = 1; i < DP.length; i++) {
            for (int j = 0; j < i; j++) {
                if (DP[j]&&words.contains(s.substring(j, i))){
                    DP[i] = true;
                }
            }
        }
        System.out.println(Arrays.toString(DP));
        return DP[DP.length-1];
    }

    public static void main(String[] args) {
        String s = "applepenapplepe";
        String[] words = {"apple", "pen"};
        List<String> wordDict = new ArrayList<String>(Arrays.asList(words));
        System.out.println((new Solution2()).wordBreak(s, wordDict));
    }
}
