package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
/**
 * 给两个数n,k。找出1……n中所有的k个数的组合
 * 思路：使用DFS搜索，搜索的层数为K，并且使用默认的前后顺序以防止重复
 * */
	private int n;
	private int k;
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmpRes = new ArrayList<Integer>();
        this.n = n;
        this.k = k;
        dfs(1, 1, tmpRes);
        return res;
    }
	public void dfs(int index, int depth, List<Integer> tmpRes) {
		if (depth==k+1) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(tmpRes);
			res.add(tmp);
			return;
		}
		// 遍历并访问下一层
		for (int i = index; i <= n; i++) {
			tmpRes.add(i);
			dfs(i+1, depth+1, tmpRes);
			tmpRes.remove((Integer)i);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<List<Integer>>res = solution.combine(4, 5);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

}
