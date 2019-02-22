package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
/**
 * 4 sum , 延续自2sum 3sum
 * 要求相同，唯一的区别是这次是四个数的集合
 * 按住一个，另外三个使用sum,时间复杂度为o(n^3) 
 **/	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> arr = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; ++i){
        		if (i>0&&nums[i-1]==nums[i]) continue;
        		arr.addAll(threeSum(nums, target-nums[i], i+1, nums[i]));
        }
        return arr;
    }
	public static List<List<Integer>> threeSum(int[] nums, int target, int start, int fix) {
		List<List<Integer>> ls = new LinkedList<List<Integer>>();
		int begin,end;
		if(nums.length-start<3) return ls;
		//Arrays.sort(nums); 4sum直接递增排序
		for (int i = start; i < nums.length; i++) {
			if(target<=0&&nums[i]>0) break;
			if(i>start&&nums[i]==nums[i-1]) continue;
			begin = i+1;
			end = nums.length-1;
			while(begin<end){
				System.out.println(nums[begin]+"+"+nums[end]+"+"+nums[i]);
				if (nums[begin]+nums[end]+nums[i]==target) {
					ArrayList<Integer> arrayList = new ArrayList<>();
					arrayList.add(fix);
					arrayList.add(nums[i]);
					arrayList.add(nums[begin]);
					arrayList.add(nums[end]);
					ls.add(arrayList);
					while(begin<nums.length&&nums[begin]==arrayList.get(2)) begin++;//去除重复元素
					while(end<i&&nums[end]==arrayList.get(3)) end--;
				}
				else if (nums[begin]+nums[end]+nums[i]>target) {
					end--;
				}
				else {
					begin++;
				}
			}
		}
		return ls;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-5,-5,-3,2,5,0,4};
		//{-5,-2,1,1,3,5,5,5}
		int target = -7;
		System.out.println(fourSum(nums, target));
	}

}
