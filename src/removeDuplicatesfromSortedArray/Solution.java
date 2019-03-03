package removeDuplicatesfromSortedArray;
/**
 * 数组去重，王道原题之一，使用计数器记录重复个数
 * 每个元素按照重复个数前移
 * */
public class Solution {
	public static int removeDuplicates(int[] nums) {
		int count = 0;
		for(int i = 0; i<nums.length; ++i){
			nums[i-count] = nums[i];
			if(i!=nums.length-1&&nums[i]==nums[i+1]){
				count++;
			}
		}
        return nums.length-count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,0,1,1,1,2,2,3,3,4};
		removeDuplicates(input);
//		for (int i : input) {
//			System.out.println(i);
//		}
	}

}
