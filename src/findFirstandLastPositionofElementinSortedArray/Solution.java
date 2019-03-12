package findFirstandLastPositionofElementinSortedArray;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums.length==0||target<nums[0]|| target>nums[nums.length-1]) return res;
        int left = 0, right = nums.length, mid;
        //找最左边的下标
        while(left<=right){
        	mid = (left+right)/2;
        	if(nums[mid]==target){
        		res[0] = mid;
        		right = mid - 1;
        	}else if (target<nums[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
        }
        left = 0;
        right = nums.length-1;
        //寻找最右下标
        while(left<=right){
        	mid = (left+right)/2;
        	if(nums[mid]==target){
        		res[1] = mid;
        		left = mid + 1;
        	}else if (target<nums[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
        }
        return res;
    }
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {5,7,7,8,8,10}, res;
		int target = 6;
		res = solution.searchRange(input, target);
		System.out.println(res[0]+" "+res[1]);
	}

}
