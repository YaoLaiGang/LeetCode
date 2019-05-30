package sortColors;
/*
* 给颜色排序，0;红色 1：白色 2：蓝色
* 给一个颜色数组，要求排序后按照红白蓝的顺序排序
* */
/*Input: [2,0,2,1,1,0]
  Output: [0,0,1,1,2,2]*/

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        //题目给出了一种排序方法，即计数排序，就是记录一下0,1,2的个数，然后依次插入0,1,2
        //这种方法需要遍历两次，应该还有遍历一次的方法
        int count0 = 0, count1 = 0, count2 = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    ++count0;
                    break;
                case 1:
                    ++count1;
                    break;
                case 2:
                    ++count2;
                    break;
            }
        }
        i = 0;
        //插入0,1,2
        while (count0!=0){
            nums[i++] = 0;
            --count0;
        }
        while (count1!=0){
            nums[i++] = 1;
            --count1;
        }
        while (count2!=0){
            nums[i++] = 2;
            --count2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,0,0,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
