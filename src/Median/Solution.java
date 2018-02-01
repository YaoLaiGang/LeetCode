package Median;
/**
 * 本题为王道原题,老朋友了,在两个排好序的数组中找到中位数
 * 分别对2个序列求中位数：s1_median 和 s2_median。
   case0：if (s1_median == s2_median) then s1_median is the answer;
   case1:  if( s1_median > s2_median) then eliminate every elements > s1_median  from S1,
                                   eliminate every elements < s2_median  from S2 likewise.
   case2:  if( s1_median > s2_median) 与case1对偶，略。

对于剩余的部分，重复以上步骤，直到只剩下2个元素。
由于每次会使问题规模缩小一半，故时间O(logn) ,辅助空间O(1).

或者直接新建一个数组,按照list合并的算法合并,最后给出中值
 * */
public class Solution {
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int[] num = new int[nums1.length+nums2.length];
    	int p1=0,p2=0,k=0;
    	while(p1<nums1.length&&p2<nums2.length){
    		if(nums1[p1]<nums2[p2]){
    			num[k++]=nums1[p1++];
    		}
    		else {
    			num[k++]=nums2[p2++];
    		}
    	}
    	while(p1<nums1.length){
    		num[k++]=nums1[p1++];
    	}
    	while(p2<nums2.length){
    		num[k++]=nums2[p2++];
    	}
    	int n = num.length;
    	if(n%2==0){
    		return (num[(num.length-1)/2]+num[(num.length-1)/2+1])/2.0;
    	}else{
    		return num[(num.length-1)/2];
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
	}

}

/*int l1=0,r1=nums1.length-1,m1,l2=0,r2=nums2.length-1,m2,flag1=0,flag2=0;
double midnum1=0,midnum2=0;
while(l1<r1&&l2<r2){
	m1=(r1+l1)/2;
	m2=(r2+l2)/2;
	if((r1-l1+1)%2==0)//偶数序列,
	{
		midnum1=(nums1[m1]+nums1[m1+1])/2.0;
		flag1=1;
	}
	else{
		midnum1=nums1[m1];
		flag1=0;
	}
	if((r2-l2+1)%2==0)
	{
		midnum2=(nums2[m2]+nums2[m1+1])/2.0;
		flag2=1;
	}
	else{
		midnum2=nums2[m2];
		flag2=0;
	}
//	判断两位数大小,缩小数组 {1,2} {0,3}=>{0,1,2,3}
	if(midnum1==midnum2)
	{
		System.out.println(midnum1+"=>"+midnum2);
		return midnum1;
	}
	else if(midnum1>midnum2)//第一个数组的中位数大于第二个的,留下第一个的左侧和第二个的右侧,继续循环
	{
		//留下第一个的左侧
		if(flag1==1)
		{
			r1=m1;
		}
		else
		{
			r1=m1-1;
		}
//		留下第二个的右侧
		l2=m2+1;
	}
//	与上一种情况相反
	else
	{
		//留下第2个的左侧
		if(flag2==1)
		{
			r1=m2;
		}
		else
		{
			r1=m2-1;
		}
//		留下第1个的右侧
		l1=m1+1;
	}
}
//没有相同的值,
//case (两个数列均为偶数列) 将两数组最后剩余的值加起来除二
//case (两个数列一个是奇数列,一个是偶数列) 
if(nums1.length%2==1||nums2.length%2==1){
	return 0;//此处无法判断
}
else
	return (nums1[l1]+nums2[l2])/2.0;*/
