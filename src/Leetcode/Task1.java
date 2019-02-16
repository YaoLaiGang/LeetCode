package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *@since 2018年01月06日09:12:00 
 *@author peter
 *@version 1.0
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * */
public class Task1 {
	
	public static int[] twoSum(int nums[],int target){// 时间复杂度太高，用空间换时间
		int[] res = new int[2];
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]+nums[i]==target){
					res[0]=i;
					res[1]=j;
				}
			}
		}
		return res;
	}
	public static int[] twoSum2(int nums[],int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i<nums.length; ++i){
			if (hashMap.containsKey(target-nums[i])) {
				res[0] = hashMap.get(target-nums[i]);
				res[1] = i;
				return res;
			}
			hashMap.put(nums[i], i);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum2(nums, target)));
	}
}
