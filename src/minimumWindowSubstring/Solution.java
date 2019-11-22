package minimumWindowSubstring;

import java.util.HashMap;

/*
* 给两个字符串S, T
* 在S中找到包含T的最短连续字符串
* Input: S = "ADOBECODEBANC", T = "ABC"
* Output: "BANC"
* 解题思路：
* 这是双指针的高级应用，滑动窗口问题，首先先维持一个窗口大小为0的窗口
* 右指针向右扩张元素，直到出现重复元素
* 此时的窗口有两种可能： 1. 当前窗口存在最小子串 2.右侧未访问元素存在最小子串
* 为了确定问题一，窗口左指针向右移动，缩小窗口直到窗口不再包含T
* 为了确定问题二，在窗口不重复后，右指针继续扩张元素
* 重复上述步骤
*
* 改进版：由于常用字母总共只有128个，所以完全可以不用Map而改用空间大小为128的数组，直接用字符当索引，里面的值就是个数
* 另外不用每次都subString，只需要minLen和起始位置即可
* */
public class Solution {
    private String minWindow(String s, String t) {
        int minlen = Integer.MAX_VALUE, left = 0, right = 0, len = t.length(), sLen = s.length(), minleft = 0;
        if (len<1) return "";
        String res = ""; // 保存minlen对应的字符串
        HashMap<Character, Integer> countT = new HashMap<>(), win = new HashMap<>();
        Character ch,c;
        for (int i = 0; i < len; i++) {
            c = t.charAt(i);
            countT.put(c, countT.containsKey(c)?countT.get(c)+1 : 1);
        }
        while (right<sLen){
            // 右指针扩张，直到包含所有的T中的元素
            while (right<sLen&&len!=0){
                ch = s.charAt(right); // 要增加元素
                win.put(ch, win.containsKey(ch) ? win.get(ch)+1 : 1);
                if (countT.containsKey(ch)&&win.get(ch)<=countT.get(ch)){
                    --len;
                }
                ++right;
            }
            if (len!=0) break; // 不存在包含字符串T的解
            // left-right 包含T，但是可能不是最小，此时需要缩小窗口
            while (left<right){
                ch = s.charAt(left);//要从窗口中删除的元素
                win.put(ch, win.get(ch)-1);
                left++;
                if (countT.containsKey(ch)&&win.get(ch)<countT.get(ch)) {
                    ++len;
                    break;
                }
            }
            // left-1->right-1为当前包含T的最小子串
            if (right-left+1 < minlen){
                minlen = right - left +1;
                minleft = left;
                System.out.println("tmp res :"+ res);
            }
        }
        return s.substring(minleft-1, minlen+minleft-1);
    }

    // 改进的滑动窗口，不使用HashMap
    private String minWindow2(String s, String t) {
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, tLen = t.length(), sLen = s.length(), nLen = t.length(), minleft = 0;
        int[] countT = new int[128], countS = new int[128];
        char ch;
        String res = "";
        for (int i = 0; i < tLen; i++) {
            ++countT[t.charAt(i)];
        }
        while (right<sLen){
            // 向右扩展元素，知道包含了t中的所有元素
            while (right<sLen&&nLen!=0){
                ch = s.charAt(right);
                ++countS[ch];
                if (countT[ch]!=0&&countS[ch]<=countT[ch]) --nLen;
                right++;
            }
            if (nLen!=0) break;
            // left-right 包含T，但是可能不是最小，此时需要缩小窗口
            while (left<right){
                ch = s.charAt(left);
                --countS[ch];
                left++;
                if (countT[ch]!=0&&countS[ch]<countT[ch]) {
                    ++nLen;
                    break;
                }
            }
            if (right-left+1<minLen){
                minLen = right - left +1;
                minleft = left;
//                System.out.println("tmp res :"+ res);
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minleft-1, minLen+minleft-1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow2("cabwefgewcwaefgcf", "z"));
//        System.out.println((int)'A'+" "+(int)'z');
    }
}
