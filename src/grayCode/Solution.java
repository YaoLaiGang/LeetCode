package grayCode;

import mergeKSortedLists.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 给一个二进制数字长度N，生成一组格雷码
    * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码
    * 格雷码公式：G(n) =  n XOR (n/2)
    * */
    public List<Integer> grayCode(int n) {
        int len = (int)Math.pow(2, n);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(i ^ (i/2));
        }
        System.out.println(res);
        return  res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.grayCode(0);
    }

}
