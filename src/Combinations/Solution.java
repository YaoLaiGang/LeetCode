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
		// 遍历并访问下一层， 这里可以改进一下i的上限，因为长度固定的情况下，剩余元素不足就不用遍历了
		// 当前长度tmpRes.size()==depth, 剩余元素 n-i, 最少剩余元素 k-(tmpRes.size())
		// n-i >= k - tmpRes.size()   ====> i <=n-k+tmpRes.size()
		for (int i = index; i <= n-k+depth; i++) {
			
			tmpRes.add(i);
			dfs(i+1, depth+1, tmpRes);
			tmpRes.remove(tmpRes.size()-1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<List<Integer>>res = solution.combine(4, 2);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

}
