package searchinRotatedSortedArray;

public class Solution {
/**
 * 在一个排好序然后旋转的数组中查找，要求时间复杂度为O(logn)
 * 例如：[0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2] => 排好序，然后旋转
 * 首先二分查找时间复杂度满足要求，但是这里并不是完全有序，且旋转轴未知
 * 对于数组[0 1 2 4 5 6 7] 共有下列七种旋转方法：
0　　1　　2　　 4　　5　　6　　7
7　　0　　1　　 2　　4　　5　　6
6　　7　　0　　 1　　2　　4　　5
5　　6　　7　　 0　　1　　2　　4
4　　5　　6　　 7　　0　　1　　2
2　　4　　5　　 6　　7　　0　　1
1　　2　　4　　 5　　6　　7　　0
二分搜索法的关键在于获得了中间数后，判断下面要搜索左半段还是右半段，上图七种转化方式中
如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，
则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，
这样就可以确定保留哪半边了
 * */
	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length-1, mid = (left+right)/2;
		while(left<=right){
			mid = (left+right)/2;
			if(nums[mid]<nums[right]){// 中间小于右边，右边数组有序
				if(target>=nums[mid]&&target<=nums[right]){//右侧进行二分查找
					System.out.println("debug"+1);
					return InsertionSearch(nums, target, mid, right);
				}else{// 要查找数在左侧无序区
					right = mid - 1;
					continue;
				}
			}else{//左侧有序
				if(target>=nums[left]&&target<=nums[mid]){//左侧进行二分查找
					System.out.println("debug"+2);
					return InsertionSearch(nums, target, left, mid);
				}else{// 要查找数在右侧无序区
					left = mid + 1;
					continue;
				}
			}
		}
		if(left>=0&&left<nums.length){
			if(nums[left]==target) return left;
		}
		return -1;
    }
//	插值查找,此算法十分经典，应当熟记
	public static int  InsertionSearch(int nums[], int target, int left, int right) {
		int mid;
		while(nums[left]!=nums[right]&&target>=nums[left]&&target<=nums[right]){
			mid = left + (target-nums[left])/(nums[right]-nums[left])*(right-left);
			System.out.println("left:"+nums[left]+" right:"+nums[right]+" mid:"+nums[mid]);
			if(nums[mid]==target){
				return mid;
			}
			else if (target>nums[mid]) {
				left = mid+1;
			}else {
				right = mid-1;	
			}
		}
		if(target==nums[left]) return left;
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[2,3,4,5,6,7,8,9,1]
//		9
		int[] nums = {4,5,6,7,0,1,2};
		int target = 3;
//		for (int i : nums) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		System.out.println(InsertionSearch(nums, target, 3, nums.length-1));
		System.out.println(search(nums, target));
	}

}
