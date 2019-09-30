package subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
/*
* 求子集，不过和1不同的是，2中的数组数组中可能存在重复的数字
* 这个肯定还是DFS大法好了
* */
    private int[] nums;
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> tempList = new ArrayList<>();
        // 遍历还要去重
        dfs(0, 0, tempList);
        return  res;
    }
    public void dfs(int depth, int i, List<Integer> tempList){
        if (depth == nums.length+1) return;
        res.add(new ArrayList<>(tempList));
        for (int j = i; j < nums.length; j++) {
            if (j>i&&nums[j]==nums[j-1]) continue;
            tempList.add(nums[j]);
            dfs(depth+1, j+1, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,4,4,1,4};
        System.out.println(solution.subsetsWithDup(nums));
    }
}
