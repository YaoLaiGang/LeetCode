package firstMissingPositive;

public class Solution {
/*
 *有一个未排序的数组，找出其中缺失的最小的正数
 *Input: [1,2,0]
 *Output: 3 
 *
 *Input: [3,4,-1,1]
 *Output: 2			
 *要求时间复杂度为O(n) 空间复杂度为O(1)				
 * */	
	public int firstMissingPositive(int[] nums) {
/*
 * 思路：遍历数组，将遍历的数放到该放的位置（1>0 2>1…… n>n-1）,也就是和对应的位置互换
 * 然后第二次遍历，第一个和位置对应的数不符的下标+1就是要找的
 * 注意
 * ①换完以后，下标不变，因为对应下标换来的是新数字，应该放置到正确的位置
 * ②或要交换的两个数相同，则直接跳过，否则会陷入死循环
 * */		
		int n = nums.length, j=0;
		for(int i=0; i<n; ++i){
			j = nums[i]-1;
			if(i!=j&&j>=0&&j<n){
//				与nums[i]-1的元素位置互换
				if(nums[i]==nums[j]) continue;//重复元素，直接跳过
				nums[i] = nums[i] + nums[j];
				nums[j] = nums[i] - nums[j];
				nums[i] = nums[i] - nums[j];
				--i;
			}
		}
		for (int i = 0; i < n; i++) {
			if(nums[i]!=i+1) return i+1;
		}
        return n+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {1,1,1,1,1};
		System.out.println(solution.firstMissingPositive(input));
	}

}
