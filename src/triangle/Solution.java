package triangle;

import java.util.*;

public class Solution {
    /*
    * 给一个三角形数组，从三角形的顶部走到尾部（只能走相邻的点，并且是向下一层走），找到一条路径使得其路过的和最小
    * 最简单的方法是DFS（PS：DFS大法好……个锤子）
    * 不过果然不是一般题目，普通的DFS超时了
    * 这里其实是用的动态规划, sum[i][j] = min(sum[i - 1][j - 1], sum[i - 1][j])
    * 当然这个问题也可以倒着来（反正都是求加法）
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.get(triangle.size()-1).size()];
        int min = Integer.MAX_VALUE;
        sum[0] = triangle.get(0).get(0);
        int depth = triangle.size();
        for (int i = 1; i < depth; i++) {
            for (int j = i; j >= 0; j--) {
                ArrayList<Integer> pre = (ArrayList<Integer>) triangle.get(i);
                if (j==0) {
                    sum[0] += pre.get(0);
                    break;
                }
                if (j==i){
                    sum[i] = sum[i-1] + pre.get(i);
                    continue;
                }
                sum[j] = Math.min(sum[j]+pre.get(j), sum[j-1]+pre.get(j));
            }
        }
        for (int value : sum) {
            if (value < min) min = value;
        }
        return min;
    }
    // 倒着求的方法
    public int minimumTotal2(List<List<Integer>> triangle) {
        ArrayList<Integer> sum = (ArrayList<Integer>) triangle.get(triangle.size()-1), pre;
        for (int i = triangle.size()-2; i >= 0; i--) {// i为层数
            pre = (ArrayList<Integer>)triangle.get(i);
            for (int j = 0; j <= i; j++) {
                sum.set(j, pre.get(j)+Math.min(sum.get(j), sum.get(j+1)));
            }
        }
        return sum.get(0);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Collections.singletonList(2)));
        input.add(new ArrayList<>(Arrays.asList(3,4)));
        input.add(new ArrayList<>(Arrays.asList(6,5,7)));
        input.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(solution.minimumTotal2(input));
    }
}
