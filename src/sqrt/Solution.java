package sqrt;
/*
* 求sqrt，结果返回截断的正数
* */
public class Solution {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(9));
    }
}
