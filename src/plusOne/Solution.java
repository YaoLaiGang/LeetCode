package plusOne;

import java.util.Arrays;

/*
* 这题给了一个非空字符数组，表示一个数字【1,2,3】就表示123
* 然后返回一个这个数组+1的结果数组【1,2,4】
* 问题在于进位，返回的长度可能会多一位，估计不能把数还原出来，有可能是大整数
* */
public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length, high = 0;//最高位
        digits[len-1]+=1;
        for (int i = len-1; i >= 0; i--) {
            if (digits[i]>=10){
                if (i!=0){
                    digits[i-1] += digits[i]/10;
                }else {//多出一位
                    high = digits[i]/10;
                }
                digits[i] = digits[i]%10;
            }
        }
        if (high==0) return digits;
        else {
            int[] res = new int[len+1];
            res[0] = high;
            for (int i = 0; i < len; i++) {
                res[i+1] = digits[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        System.out.println(Arrays.toString(solution.plusOne(input)));
    }
}
