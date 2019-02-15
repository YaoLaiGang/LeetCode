package MaxSubArray;

public class Solution {
/**
 * 给一个数组，求出其子数组（相邻）和的最大值
 * 这是MinMaxDP
 * */
	public static int maxSubArray(int nums[]) {
		int[] F = new int[nums.length];
		int max = nums[0];
		F[0] = nums[0];
		for(int i = 1; i< nums.length; ++i){
			F[i] = Math.max(F[i-1]+nums[i], nums[i]); 
			max = max>F[i] ? max : F[i];
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("res"+maxSubArray(nums));
	}

}
