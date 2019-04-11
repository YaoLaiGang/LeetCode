package permutations;

import java.util.ArrayList;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {};
		List<List<Integer>> res = solution.permute(input);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer+"\t");
			}
			System.out.println();
		}
	}

}
