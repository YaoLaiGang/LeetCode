package JumpGame2;

public class Solution {
/**
 * 和JumpGame类似，只不过本题要求跳到最后一个地方所需要的最小跳数
 * 问题变成了最大最小动态规划问题
 * */
	public static int jump(int[] nums) {
		int[] minJump = new int[nums.length];
		minJump[0] = 0;
		for(int i=1; i<minJump.length; ++i){
			minJump[i] = Integer.MAX_VALUE;
			for (int j = i-1; j >= 0; --j) {
				if (j+nums[j]>=i && minJump[j] != Integer.MAX_VALUE) {
					minJump[i] = minJump[i]<minJump[j]+1 ? minJump[i]: minJump[j]+1;
				}
			}
		}
		for (int i : minJump) {
			System.out.println(i);
		}
		return minJump[nums.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1};
		System.out.println("res"+jump(nums));
	}

}
