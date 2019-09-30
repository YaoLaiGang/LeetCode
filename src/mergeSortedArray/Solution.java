package mergeSortedArray;

import java.util.Arrays;

public class Solution {
    /*
    * 合并两个排好序的数组，其中num1有m个元素,num2有n个元素,把num2合并到num1当中去
    * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //按照链表法的思路，最快的方法莫过于m+n的空间谁小添加谁了
        int i=0,j=0,k=0;
        int[] num1_cp = Arrays.copyOf(nums1,m+n);
        while (i<m&&j<n){
            if (num1_cp[i]<=nums2[j]){
                nums1[k++] = num1_cp[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }
        while (i<m){
            nums1[k++] = num1_cp[i++];
        }
        while (j<n){
            nums1[k++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0}, nums2 = {1};
        Solution solution = new Solution();
        solution.merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
