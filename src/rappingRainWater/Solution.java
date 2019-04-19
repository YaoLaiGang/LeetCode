package rappingRainWater;

import java.util.Stack;

public class Solution {
/*
 * 给一个非负数组，每个数代表这个地方插得柱子的长度
 * 求这些柱子能存放多少雨水
	Input: [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
 *思路，使用栈来存储下标
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
		int[] input = {2,1,0,2};
		System.out.println(solution.trap(input));
	}

}
