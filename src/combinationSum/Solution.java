package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
/**
 * 给一个数组和一个数（target），数组中无重复
 * 在数组中求出所有加起来等于target的组合
 * 另外，组合中的数可以重复，例如：
 * Input: candidates = [2,3,6,7], target = 7,
	A solution set is:
	[
	  [7],
	  [2,2,3]
	]
	Input: candidates = [2,3,5], target = 8,
	A solution set is:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
	3sum 4sum等问题的升级版，这次解的个数不定，且解可以重复
	但所给的数组全是正数
 * */
	private List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
/**
 * 思路：使用DFS进行搜索，且DFS跳出的条件是结果为负数，每层的DFS都遍历一遍数组，不断缩小target
 * 维护一个变量start，保证每次遍历都是从左向右遍历而不产生重复的结果
 * */        
		this.res = new LinkedList<List<Integer>>();
        ArrayList<Integer> store = new ArrayList<Integer>();
        dfs(store, candidates, target, 0);
		return this.res;
    }
	public void dfs(ArrayList<Integer> store, int[] candidates, int target, int star) {
		if(target==0) {
			this.res.add((List<Integer>) store.clone());
			return;
		}
		if(target<0) {
			return;
		}
		for(int i = star; i<candidates.length; ++i){
			store.add(candidates[i]);
			dfs(store, candidates, target-candidates[i], i);
			store.remove(store.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] candidates = {2,3,6,7};
		int target = 10;
		List<List<Integer>> res = solution.combinationSum(candidates, target);
		for (List<Integer> list : res) {
			System.out.println((ArrayList<Integer>)list);
		}
	}

}
