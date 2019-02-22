package The3Sum;

import java.security.spec.ECFieldF2m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
/**
 * 给一个数组，找寻所有的满足相加为0的三个数
 * */
	public static List<List<Integer>> threeSum(int[] nums) {
		/**
		 * 首先对数组进行排序，时间复杂度为O(n*logn)
		 * 然后对数组进行两层的遍历，先取出当前遍历的数字为nums[i]，
		 * 然后从数组两侧取出数字分别为nums[begin]和nums[end]，
		 * 然后三个数求和值为sum == 0，将三个数加入结果之中，同时将两侧的下标向中间移动，
		 * 直到不与之前取出的数字相同，避免出现重复的三元组
		 * sum > 0，因为数组有序，说明右侧的数字过大，所以下标左移，故而执行end--
		 * sum < 0，因为数组有序，说明左侧的数字过小，所以下标右移，所以执行begin++
		 * 因为两层的遍历时间复杂度为O(n^2)，O(n*logn) + O(n^2) = O(n^2)，
		 * 所以总体时间复杂度为O(n^2)
		 * */
		List<List<Integer>> ls = new LinkedList<List<Integer>>();
		int begin,end;
		if(nums.length<3) return ls;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0) break;
			if(i>0&&nums[i]==nums[i-1]) continue;
			begin = i+1;
			end = nums.length-1;
			while(begin<end){
				if (nums[begin]+nums[end]+nums[i]==0) {
					ArrayList<Integer> arrayList = new ArrayList<>();
					arrayList.add(nums[i]);
					arrayList.add(nums[begin]);
					arrayList.add(nums[end]);
					ls.add(arrayList);
					while(begin<nums.length&&nums[begin]==arrayList.get(1)) begin++;//去除重复元素
					while(end<i&&nums[end]==arrayList.get(2)) end--;
				}
				else if (nums[begin]+nums[end]+nums[i]>0) {
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
		int[] nums = {-2 ,-1, 1, 2};//{-2 -1 1 2}
		//(-2,-1)(-2,1)(-2,2)(-1,1)(-1,2)(1,2)
		System.out.println(threeSum(nums));
	}

}
