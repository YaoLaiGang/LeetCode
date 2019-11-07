package pascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 生成杨辉三角，就是该行某个值等于上一行其左右肩膀值之和
    * */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp, pre;
        // 假设在本行是第i个，它的值就是上一行的第i-1和i个
        for (int i = 1; i <= numRows; i++) {
            tmp = new ArrayList<>(i);
            for (int j = 1; j <= i; j++) {
                if (j>1&&j<i){
                    pre = (ArrayList<Integer>) res.get(res.size()-1);
                    tmp.add(pre.get(j-2)+pre.get(j-1));
                }else{
                    tmp.add(1);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.generate(6);
        System.out.println(res);
    }
}
