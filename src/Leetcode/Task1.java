package Leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *@since 2018年01月06日09:12:00 
 *@author laigang
 *@version 1.0
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * */
public class Task1 {
	
	public static int[] twoSum(int nums[],int targer){
		int[] res = new int[2];
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]+nums[i]==targer){
					res[0]=i;
					res[1]=j;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			arr.add(in.nextInt());
		}
		int targer = in.nextInt(),k=0;
		//数组转换
		int[] nums = new int[arr.size()];
		for (int i : arr) {
			nums[k++]=i;
		}
		twoSum(nums, targer);
	}

}
