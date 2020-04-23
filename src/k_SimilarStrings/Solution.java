package k_SimilarStrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    * A和B相似就是A能通过交换他的字母变成B 如ab -> ba
    * 现在给你A和B，求A->B的最小交换次数
    *
    * 思路：提到最小不难想到BFS，我们可以用BFS来进行搜索
    * 从前往后，每次交换一个单词，使得该位置与B相同
    * */
    public int kSimilarity(String A, String B) {
        int len = A.length(), res = 0; // 该遍历第几个轮次
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(A);
        visited.add(A);
        while (!q.isEmpty()){
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(B)) return res;
                int cnt = 0;
                while (cnt<len&&node.charAt(cnt)==B.charAt(cnt)) ++cnt;
                for (int j = cnt+1; j < len; j++) {
                    if (node.charAt(j)==B.charAt(cnt)) {
                        String insert = exchangeIndex(node, cnt, j);
                        if (!visited.contains(insert)){
                        visited.add(insert);
                        q.offer(insert);
                        }
                    }
                }
            }
            ++res;
        }
        return -1;
    }
    public String exchangeIndex(String str, int lIdx, int rIdx){
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(lIdx), r = sb.charAt(rIdx);
        sb.setCharAt(lIdx, r);
        sb.setCharAt(rIdx, l);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).kSimilarity("ab", "ab"));
    }
}
