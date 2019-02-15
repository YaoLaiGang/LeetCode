package JumpGame;

public class Solution {
/**
 * 2019年02月09日18:31:40
 * 给一个非负数组，从下标0处出发，问能否到达终点
 * 其中，数组元素表示在该点能跳跃的最远距离
 * （存在性动态规划）(贪心算法)
 * */
	public static boolean canJump(int[] nums) {
		boolean[] ifcan = new boolean[nums.length];
		ifcan[0] = true;
		for (int i = 1; i < ifcan.length; ++i) {
			ifcan[i] = false;
			for (int j = i-1; j >= 0; --j) {
				if (ifcan[j]&&nums[j]+j>=i) {
					ifcan[i] = true;
					break;
				}
			}
		}
		return ifcan[nums.length-1];
	}
	public boolean canJump2(int[] nums) {
		/*
		 * 贪心算法的思路在于，从后向前，每次都找能调到当前位置的最靠近
		 * **/		
		int n = nums.length;
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i= {3,2,1,0,4};
		System.out.println(canJump(i));
	}

}
