package removeElement;

public class Solution {
/**
 *和去重类似，只不过这里要求去除指定的元素 
 * 
 */	
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		for(int i = 0; i<nums.length; ++i){
			nums[i-count] = nums[i];
			if(nums[i]==val){
				count++;
			}
		}
		for (int i : nums) {
			System.out.println(i);
		}
        return nums.length-count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,0,1,1,1,2,2,3,3,4};
		removeElement(input, 1);
	}

}
