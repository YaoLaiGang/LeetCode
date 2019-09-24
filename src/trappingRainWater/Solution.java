package trappingRainWater;

import java.util.Stack;

public class Solution {
/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 这道题是为了复习单调栈而重新写的，这是经典的一道单调栈的题目
 * 可以很清楚的发现只有凹槽处才能蓄水，那么凹槽就是经典的递减栈，而发现递增时说明已经有凹槽生成了
 * 单调栈有如下性质：
 * 单调递增栈可发现左起第一个比当前元素小的元素
 * 单调递减栈可以发现左起第一个比当前元素大的元素
 * */
	public int trap(int[] height) {
        int res = 0, i=0;
        Stack<Integer> index = new Stack<Integer>();
        while (i<height.length) {
            if(index.isEmpty()||height[i]<=height[index.peek()]){
                index.push(i++);
            }else{
                int mid = index.pop();
                if(index.isEmpty()) continue;
                res+= (Math.min(height[i], height[index.peek()]) - height[mid]) * (i - index.peek() - 1);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {4,2,3};
		System.out.println("result"+solution.trap(input));
	}

}
