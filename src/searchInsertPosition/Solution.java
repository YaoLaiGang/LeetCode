package searchInsertPosition;

public class Solution {
/*Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.*/
	 public int searchInsert(int[] nums, int target) {
		 //使用二分查找
		 if(target<nums[0]) return 0;
		 if(target>nums[nums.length-1]) return nums.length;
		 int left = 0, right = nums.length, mid;
		 while(left<=right){
			 mid = (left+right)/2;
			 if(target>nums[mid]){
				 left=mid+1;
			 }else if (target<nums[mid]) {
				right=mid-1;
			}else {
				return mid;
			}
		 }
	      return left;  
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {1,3,5,6};
		int target = 0;
		System.out.println(solution.searchInsert(input, target));
	}

}
