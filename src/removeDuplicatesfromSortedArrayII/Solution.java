package removeDuplicatesfromSortedArrayII;

import java.util.Arrays;

public class Solution {
/**
 * Remove Duplicates from Sorted Array 的进阶版,当然这里的数组仍然是排序完的
 * 这里允许重复一次，也就是一个元素可以出现两次，第三次就不可以了
 * 仍然使用原来的思路，使用计数器和前移的方案
 * */
	public int removeDuplicates(int[] nums) {
		if(nums.length<=2) return nums.length; //这一行很关键，由70-> 100%
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
			nums[i-count] = nums[i];
			if (i+2<nums.length&&nums[i]==nums[i+2]) {
				++count;
			}
		}
        return nums.length - count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {0,0,1,1,1,1,2,3,3};
		System.out.println(solution.removeDuplicates(input));
		System.out.println(Arrays.toString(input));
	}

}
