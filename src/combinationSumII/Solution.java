package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Solution {
/**
 * combinationsum的升级版
 * 这里的数组仍然是全正，但是里面存在重复
 * 且每个解只能用里面的每个元素一次
 * */
	private List<List<Integer>> res;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
/**
 * 思路：使用DFS进行搜索，且DFS跳出的条件是结果为负数，每层的DFS都遍历一遍数组，不断缩小target
 * 维护一个变量start，保证每次遍历都是从左向右遍历而不产生重复的结果
 * 递归的时候为防止重复利用一个元素，使用start+1
 * */        
		this.res = new LinkedList<List<Integer>>();
        ArrayList<Integer> store = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(store, candidates, target, 0);
        HashSet<List<Integer>> hashSet = new HashSet<>(this.res);
        this.res = new LinkedList<>(hashSet);
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
			dfs(store, candidates, target-candidates[i], i+1);
			store.remove(store.size()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = solution.combinationSum2(candidates, target);
		for (List<Integer> list : res) {
			System.out.println((ArrayList<Integer>)list);
		}
	}

}
