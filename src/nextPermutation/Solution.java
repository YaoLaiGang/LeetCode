package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
/**
 *下一个排列，求全排列后，结果按照字典序排序
 *给出下一个排列的结果
 *这道题让我们求下一个排列顺序，有题目中给的例子可以看出来，如果给定数组是降序，
 *则说明是全排列的最后一种情况，则下一个排列就是最初始情况，
我们再来看下面一个例子，有如下的一个数组
1　　2　　7　　4　　3　　1
下一个排列为：
1　　3　　1　　2　　4　　7
那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，
数字逐渐变大，到了2时才减小的，然后我们再从后往前找第一
个比2大的数字，是3，那么我们交换2和3，再把此时3后面的所有数字转置一下即可，步骤如下：
1　　2　　7　　4　　3　　1
1　　2　　7　　4　　3　　1
1　　3　　7　　4　　2　　1
1　　3　　1　　2　　4　　7
 * */
	public static void nextPermutation(int[] nums) {
		int i,j,tmp;
		for(i=nums.length-1;i>0;--i){
			if(nums[i-1]<nums[i]){
				break;
			}
		}
		if(i==0){// 降序直接逆置
			reverse(nums, 0, nums.length-1);
			return;
		}
		--i;
		for(j=nums.length-1;j>=0&&nums[j]<=nums[i];--j);// 从后向前第一个大于nums[i]的数字
		System.out.println(i+" "+j);
		//		i j 交换
		tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
//		i以后逆置
		reverse(nums, i+1, nums.length-1);
	}
	public static void reverse(int[] nums, int begin, int end){
		if(begin>=end) return;
		int tmp;
		while(end>begin){
			tmp = nums[end];
			nums[end] = nums[begin];
			nums[begin] = tmp;
			end--;
			begin++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,5,1};
		nextPermutation(input);
		for (int i : input) {
			System.out.println(i);
		}
		
	}

}
