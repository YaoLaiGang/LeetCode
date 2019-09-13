package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
/**
 * 给一个数字数组，求其子集
 * 该问题承接上一个问题Combinations
 * 1.可以多次调用上一个问题的方法，K是从1-n
 * 2.由于DFS是分层的，那么我的问题其实是K==n时每一层的结果的集合，这时候只需要访问一次就可以得到所有的答案
 * */
	private int n;
	private List<List<Integer>> res;
	private int[] nums;
	public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        List<Integer> tempRes = new ArrayList<Integer>();
        n = nums.length;
        this.nums = nums;
        res.add(new ArrayList<Integer>());
        dfs(0, 0, tempRes);
        return res;
    }
	public void dfs(int depth, int i, List<Integer> tempRes) {
		if (depth==n||i==n) return;
		for (int j = i; j < n; j++) {
			tempRes.add(nums[j]);
			ArrayList<Integer> tmp = new ArrayList<Integer>(tempRes);
			res.add(tmp);
			dfs(depth+1, j+1, tempRes);
			tempRes.remove(tempRes.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] nums = {1,2,3,4};
		List<List<Integer>>res = solution.subsets(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

}
