package ThreeSumClosest;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
/**
 * 类似3sum，不过本题要求的是三个数的和与target更接近，并返回这个和
 * */	
	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length<3) return target;
		int res = nums[0]+nums[1]+nums[2], begin, end;
		Arrays.sort(nums);
		if (target>0) {
			for(int i=0;i<(nums.length)/2;i++)
			{	// 数组逆置
				int temp=nums[i];
				nums[i]=nums[nums.length-i-1];
				nums[nums.length-i-1]=temp;
			}
		}
		for(int i=0; i<nums.length; ++i){
			if (target>0&&nums[i]<0) break; //递减
			if (target<=0&&nums[i]>0) break; //递增
			if(i>0&&nums[i]==nums[i-1]) continue;
			begin = i+1;
			end = nums.length-1;
			while(begin<end){
				if (nums[begin]+nums[end]+nums[i]==target) {
					return target;
				}
				else if (nums[begin]+nums[end]+nums[i]>target) {
					res = Math.abs(res-target) < nums[begin]+nums[end]+nums[i]-target? res : nums[begin]+nums[end]+nums[i]; 
					if(target>0) begin++;
					else end--;
				}
				else {
					res = Math.abs(res-target) < target-(nums[begin]+nums[end]+nums[i]) ? res : nums[begin]+nums[end]+nums[i];
					if(target>0) end--;
					else begin++;
				}
			}
		}
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[1,2,4,8,16,32,64,128]
		
		int[] nums = {1,2,4,8,16,32,64,128};
		int target = 82;
		System.out.println(threeSumClosest(nums, target));
	}

}
