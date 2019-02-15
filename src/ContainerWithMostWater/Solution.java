package ContainerWithMostWater;

public class Solution {

    public static int maxArea(int[] height) {
    	int maxArea = 0,left = 0,right = height.length-1;
    	while(left<right){
    		if(((height[left]<height[right]?height[left]:height[right])*(right-left))>maxArea){
    			maxArea = ((height[left]<height[right]?height[left]:height[right])*(right-left));
    		}
    		if(height[left]<height[right]){
    			left++;
    		}
    		else{
    			right--;
    		}
    	}
    	return maxArea;
    }
}
