package permutationSequence;

import java.util.ArrayList;
import java.util.List;

/*
* 给一个n , 一个 k
* 对1-n进行全排列，这个排列排序后求出第k个
* 举个栗子：n=3 k=3
* 123
* 132
* 213
* 231
* 312
* 321
* 分析：
* 第一个元素按照1,2,3的顺序循环，周期为（3-1）！ = 2
* k = 3 时，(3-1)/2 = 1 , 即为2
* 第二个元素按照 1,3 的顺序循环，周期为(2-1)! = 1
* k=3 在 头一个元素为2 时的顺序 (3-1)%2+1 = 1
* (1-1)/1 = 0 , 即为3
*
* 用递归求解即可
* */
public class Solution {
    private ArrayList<Integer> elem;
    private int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
    private String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        elem = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            elem.add(i);
        }
        getRes(n, k, res);
        return res.toString();
    }
    private void getRes(int n, int k, StringBuilder res){
        if(n==1){
            res.append(elem.get(0));
            return;
        }
        int num = elem.get((k-1)/fact[n-1]);
        elem.remove((Integer) num);
        res.append(num);
        getRes(n-1, (k-1)%fact[n-1]+1, res);
    }
    /*private int factorial(int number) {
        // 获取阶层
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }*/
    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.getPermutation(4,13);
        System.out.println(res);
//        System.out.println(solution.factorial(0));
    }
}
