package searchinRotatedSortedArrayII;

public class Solution {
/**
 * 这是一道进阶题，和searchinRotatedSortedArray类似(https://github.com/YaoLaiGang/LeetCode/blob/master/src/searchinRotatedSortedArray/Solution.java)，
 * 仍然是一个数组排好序之后旋转，
 * 在旋转后的数组里查询是否存在某个数，复杂度仍然要求是O(logn) [二分查找]
 * 不同之处在于这里给的数据中存在重复数字,也就是在判定是否有序的过程中出现了相等的状况
 * 1 2 3 5 5 5 5  => 5>1 左侧有序 5<= 5 右侧有序，且全是5
 * 5 1 2 3 5 5 5  => 3<5 左侧无序 3<5 右侧有序
 * 5 5 1 2 3 5 5  => 2<5 左侧无序 2<5 右侧有序
 * 5 5 5 1 2 3 5  => 1<5 左侧无序 1<5 右侧有序
 * 5 5 5 5 1 2 3  => 5<=5 左侧有序，且全是5 5>3 右侧无序
 * 3 5 5 5 5 1 2  => 5>3 左侧有序 5<2 右侧无序
 * 2 3 5 5 5 5 1  => 5>2 左侧有序 5>1 右侧无序
 * 也就是说，只要mid>left 左侧一定有序，只要mid<right 右侧一定有序
 * 如果出现相等，无法判定是否有序，这时候没有办法砍掉一般，比如：
 * 5,5,2,5,5,5,5
 * 只能顺序查找
 * 
 * 思路仍是二分查找，每次砍掉一半，并且两半中必有一半有序一半无序
 * 无序采取接着砍的思路，有序采取二分查找的思路
 * 
 * */
	public boolean search(int[] nums, int target) {
		if(nums.length==0) return false;
		int left=0,right=nums.length-1, mid;
		while (right>left) {
			mid = (left+right)/2;
			if (nums[mid]==target) return true;
			if (nums[mid]>nums[left]) {//左侧有序，右侧除非是相同的元素，否则无序
				if (target<=nums[mid]&&target>=nums[left]) {// 在有序的地方
					right = mid-1;
				}
				else {// 在无序的地方
					left = mid+1;
				}
			}
			else if(nums[right]>nums[mid]){//右侧有序
				if (target>=nums[mid]&&target<=nums[right]) {//在有序的地方
					left = mid+1;
				}
				else {//在无序的地方
					right = mid-1;
				}
			}else {//两侧相等，无法获知元素到底在左侧还是右侧，只能一次遍历
				for(int i = left; i<=right; ++i) {
					if(nums[i]==target) {
						left=i;
						right=i;
						break;
					}
				}
				if(left!=right) return false;
			}
			
		}
		System.out.println(left+" and "+right);
		if (target==nums[left]) {
			return true;
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = {3,1};
		int target = 1;
		System.out.println(solution.search(nums, target));
	}

}
