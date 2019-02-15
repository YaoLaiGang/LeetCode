package coinChange;

import org.omg.CORBA.portable.ValueBase;

public class CoinChange {
/**
 * 今有2元，5元，7元三种硬币数量不限
 * 先书店有书，售价M元（M>=0）
 * 那么请问凑够M元最少需要多少硬币？（最值动态规划问题）
 * */
	public static int coinChange(int A[], int M){
		// A[i]表示凑够i元所需要的最少的硬币个数
		// M表示需要凑够的钱数
		A = new int[M+1];
		int[] value = {2,5,1};
		A[0] = 0;
		for(int i = 1;i<=M;++i){
			/*int min = Integer.MAX_VALUE;
			int tmp;
			for (int j : value) {
				tmp = i-j < 0 ? Integer.MAX_VALUE : A[i-j];
				min = tmp<min? tmp: min;
			}
			A[i] = min<Integer.MAX_VALUE? min+1: Integer.MAX_VALUE ;*/
//			快速写法,节省空间
			A[i] = Integer.MAX_VALUE;
			for (int j : value) {
				if (i>=j&&A[i-j]!=Integer.MAX_VALUE) {
					A[i] = A[i]<A[i-j]+1 ? A[i] : A[i-j]+1;
				}
			}
 		}
		for (int i : A) {
			System.out.println(i);
		}
		return A[M] == Integer.MAX_VALUE ? -1 : A[M];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = null;
		System.out.println("resis:" + coinChange(A, 11));
	}
	
}
