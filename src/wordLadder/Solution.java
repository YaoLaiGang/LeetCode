package wordLadder;


import java.util.*;

/*
* 字梯问题：给beginWord和endWord还有一个Word list
* 要找一条路径从begin word开始，每次更换一个单词，且更换完的单词要在word list 中
* 通过n次更换最后到达endword，返回结果n               
*
* 这个问题想起来还是挺麻烦的
* 建立图，使用图的广度优先遍历,迭代的次数就是返回的结果n, 但是这样似乎有点慢
*
* 另一种思路是使用双向BFS，就是beginWord和endWord两路同时进行BFS，当两者BFS到同一个单词的时候
* */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int n = 0;
        boolean[] visited = new boolean[wordList.size()];
//        HashSet<String> visited = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        String iter;
        while (!queue.isEmpty()){
            ++n;
            for (int i = queue.size(); i>0; --i){
                iter = queue.poll();
                for (int j = 0; j < visited.length; j++) {
                    if (!visited[j]&&isReplace(iter, wordList.get(j))){// 相邻且两者只差一个单词，且没有被访问过
                        if (wordList.get(j).equals(endWord)) return ++n;
                        queue.offer(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }

        }
        // 未找到
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        /*
        * 这是标准答案的解法，与自己的解法类似，不同之处在于其不是通过比较两个单词来确定是不是只差了一个字符，
        * 而是更改单词的某个字符然后查看其是否存在
        * 并使用HashSet来缩短时间，由于不遍历List/Set 所以不需要visited， 只删除即可
        * */
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int n = 0;
        String iter;
        char[] str;
        char ch;
        int len = beginWord.length();
        while (!q.isEmpty()){
            n++;
            for (int i = q.size(); i > 0; i--) {
                str = q.poll().toCharArray();
                for (int k = 0; k < len; k++) {
                    ch = str[k];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j==ch) continue;
                        str[k] = j;
                        iter = new String(str);
                        if (iter.equals(endWord)) return ++n;
                        if (!set.contains(iter)) continue;
                        q.offer(iter);
                        set.remove(iter);// 已经被访问
                    }
                    str[k] = ch;
                }
            }

        }
        return 0;
    }
    private boolean isReplace(String a, String b){
        /*
        * 该函数判定两字符不同单词的个数
        * */
        int count = 0;
        for (int i = a.length()-1; i >= 0; i--) {
            if (a.charAt(i)!=b.charAt(i)) ++count;
            if (count>1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] list = {"hot","dot","dog","lot","log","cog"};
        List<String> wordlist = new ArrayList<>();
        for (String str :
                list) {
            wordlist.add(str);
        }
        System.out.println((new Solution()).ladderLength("hit", "cog", wordlist));
    }
}
