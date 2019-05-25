package sqrt;
/*
* 求sqrt，结果返回截断的正数
* */
public class Solution {
    public int mySqrt(int x) {
        //这种方法太鸡贼了，没啥意思
        return (int)Math.sqrt(x);
    }
    public int mySqrt2(int x){
        if (x==1) return 1;
        //二分法
        long left = 0, right = x, mid;
        while (right-left>1){
            System.out.println("letf"+left+"right"+right);
            mid = (left+right)/2;
            long mid2 = mid*mid;
            if (mid2==x) return (int) mid;
            else if(mid2>x){
                right = mid;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }
    public int mySqrt3(int x){
        /*
        * 牛顿迭代法
        * 求出根号a的近似值：首先随便猜一个近似值x，然后不断令x等于x和a/x的平均数，
        * 迭代个六七次后x的值就已经相当精确了。
         * */
        float last, val = x; // 上次迭代的结果
        do {
            last = val;
            val = (val+x/val)/2;
        }while (Math.abs(val-last)>1e-5);
        System.out.println(val);
        return (int)val;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt3(2147395599));
//        System.out.println(2147395599+1073697799);
    }
}
