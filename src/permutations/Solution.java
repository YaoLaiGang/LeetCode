package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
/*
 * 生成给定Int数组的全排列
 * 
	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 *思路：使用DFS搜索所有的叶子节点，达到叶子就收集该结果
 *虽然有效，但是速度太慢
 *思路2：使用使用分治法
 * */	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> store = new ArrayList<Integer>();
        for(int i=0; i<nums.length; ++i){
        	dfs(nums, i, store, res);
        }
        return res;
    }
	public void dfs(int[] nums, int start, ArrayList<Integer> store, List<List<Integer>> res) {
		store.add(nums[start]);
		if (store.size()==nums.length) {
			System.out.println(store.toString());
			res.add((List<Integer>) store.clone());
			store.remove((Integer)nums[start]);
			return;
		}
		for(int i=0; i<nums.length; ++i){
			if (!store.contains(nums[i])) {
				dfs(nums, i, store, res);
			}
		}
		store.remove((Integer)nums[start]);
	}
	
	public void permute2(Integer[] nums, int start, int end, List<List<Integer>> res) {
//		求k到m的全排列
		
        if (start==end) {// 只剩一个元素，已经排序完毕
        	res.add(new ArrayList<>(Arrays.asList(nums)));
        	System.out.println(Arrays.toString(nums));
        	return;
		}
        for(int i = start; i<=end; ++i){
        	swap(nums, i, start);
        	permute2(nums, start+1, end, res);
        	swap(nums, i, start);
        }
//        return res;
    }
	public void swap(Integer[] nums, int i, int j) {
		if(i==j) return;
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {1,3,2};
//		List<List<Integer>> res = solution.permute(input);
//		for (List<Integer> list : res) {
//			for (Integer integer : list) {
//				System.out.print(integer+"\t");
//			}
//			System.out.println();
//		}
		Integer[] nums = new Integer[input.length];
		for(int i =0; i<input.length; ++i){
			nums[i] = input[i];
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		solution.permute2(nums, 0, input.length-1, res);
		for (List<Integer> list : res) {
		for (Integer integer : list) {
			System.out.print(integer+"\t");
		}
		System.out.println();
	}
	}

}
