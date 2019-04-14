package permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 *这里是求带有重复数字全排列，基本思路和不带重复数字的全排列相同
 *在每个位置求全排列的时候，使用Set结构来查重，防止求出重复的全排列
 * */
public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Integer[] input = new Integer[nums.length];
        for(int i=0; i<nums.length; ++i){
            input[i] = nums[i];
        }
        permute2(input, 0, nums.length-1, res);
        return res;
    }
    public void permute2(Integer[] nums, int start, int end, List<List<Integer>> res) {
//		求k到m的全排列
        if (start==end) {// 只剩一个元素，已经排序完毕
        	res.add(new ArrayList<>(Arrays.asList(nums)));
        	// System.out.println(Arrays.toString(nums));
        	return;
		}
        HashSet<Integer> unique = new HashSet<Integer>();
        for(int i = start; i<=end; ++i){
//        	if(i>start&&nums[i]==nums[i-1]) continue;
        	if(unique.contains(nums[i])) continue;
        	unique.add(nums[i]);
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
		int[] input = {0,1,0,0,9};
		List<List<Integer>> res = solution.permuteUnique(input);
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer+"\t");
			}
			System.out.println();
		}
	}

}
