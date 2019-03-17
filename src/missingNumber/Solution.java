package missingNumber;

public class Solution {
/**
 * 给一个0到N的连续数，和一个长度为N的数组
 * 求这个数组缺失的数
 * 例子：
 * Input: [3,0,1]
 * Output: 2
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * */
	public int missingNumber(int[] nums) {
		//方法一：利用等差数列的性质求和，在逐一减去nums中的数，即可求得缺失的数
		int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }	
	public int missingNumber2(int[] nums) {
//		方法二：使用异或操作，由于相同的值异或会变成0，剩下的就是要求的数
		int res=0;//0与任何数异或都是那个数
		for(int i = 0; i<nums.length; i++){
			res = res ^ (i+1) ^nums[i];
		}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {9,6,4,2,3,5,7,0,1};
		System.out.println(solution.missingNumber2(input));
	}

}
