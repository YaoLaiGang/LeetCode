package divideTwoIntegers;

public class Solution {
/**
 *不用乘法，除法，求余来实现除法
 * */
	public static int divide(int dividend, int divisor) {
		/**
		 * dividend 和 divisor 取绝对值相减， 直到dividend变-或0
		 * 返回向+/-的次数（减一）并添上正负号即可
		 * */
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
		if(dividend==divisor){
			return 1;
		}
		int count = 0;
		if(dividend==Integer.MIN_VALUE){
			if(divisor<0){
				while(dividend<=0){
					dividend-=divisor;
					count++;
				}
				return --count;
			}else {
				while(dividend<=0){
					dividend+=divisor;
					count++;
				}
				--count;
				return -count;
			}
			
		}
		if(dividend==0) return 0;
		int dividend_back = Math.abs(dividend), divisor_back = Math.abs(divisor);
		if(dividend_back<divisor_back){
			return 0;
		}
		if(dividend_back==divisor_back){
			if(dividend>0&&divisor>0||dividend<0&&divisor<0) return 1;
	        return -1;
		}
		while(dividend_back>=0){
			dividend_back-=divisor_back;
			count++;
		}
		count-=1;
		if(dividend>0&&divisor>0||dividend<0&&divisor<0) return count;
        return -count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*-2147483648
		-1*/
		System.out.println(divide(-2147483648,-2147483648));
	}

}
