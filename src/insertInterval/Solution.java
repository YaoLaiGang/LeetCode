package insertInterval;

import java.util.Arrays;

public class Solution {
/*
 * 接mergeInterval，这次是给一个不重合的界限集，插入一个边界，如果重合就合并
 * 1、最简单的方法，直接插进去，然后排序按照mergeInterval的方法进行合并
 * 2、遍历Interval集合，找到交叠的位置，然后考虑合并问题
 * 插入的话，有几种情况
 * 1. 这个新范围不和任何原来的范围相交， 直接将其插入
 * 2. 这个新范围和只有一侧和原来的范围相交， 更新那个范围
 * 3. 这个新范围与两个不同的范围相交， 删除这两个范围之间的范围，更新这两个范围
 * 4. 这个新范围与两个相同的范围相交， 原范围不用动
 * */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] res;
		if (intervals.length==0){
			res = new int[1][2];
			res[0] = newInterval;
			return res;
		}
		int[] intersectionIndex = {-2, -2}, boundIndex = {-2, -2}; // 记录两个边界和Interval的相交元素的下标
		for(int i=0; i<intervals.length; ++i){
			// 交在某个范围内的检查
			if(newInterval[0]>=intervals[i][0]&&newInterval[0]<=intervals[i][1]) intersectionIndex[0] = i;
			if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]) intersectionIndex[1] = i;
			// 交在两个夹角内的情况
			if(i==0){
				if (newInterval[0]<intervals[i][0]) {//-2表示在0之前
					boundIndex[0] = -1;
				}
				if (newInterval[1]<intervals[i][0]) {
					boundIndex[1] = -1;
				}
			}
			if(i != intervals.length-1) {
				if (newInterval[0] > intervals[i][1] && newInterval[0] < intervals[i + 1][0]) boundIndex[0] = i;
				if (newInterval[1] > intervals[i][1] && newInterval[1] < intervals[i + 1][0]) boundIndex[1] = i;
			}else {
				if (newInterval[0]>intervals[i][1]) {
					boundIndex[0] = i;
				}
				if (newInterval[1]>intervals[i][1]) {
					boundIndex[1] = i;
				}
				//整个就在所有的右侧
			}
		}
		System.out.println("intersectionIndex"+Arrays.toString(intersectionIndex));
		System.out.println("boundIndex"+Arrays.toString(boundIndex));
		// tip 1: 不和任何一个范围相交, 且两端在同一个缺口, 将其插入相应的范围即可
		if(boundIndex[0]!=-2&&boundIndex[1]!=-2&&boundIndex[0]==boundIndex[1]){
			res = new int[intervals.length+1][2];
			int j = 0;
			if(boundIndex[0]==-1) res[j++] = newInterval; //在最左侧
			for (int i = 0; i < intervals.length; i++) {
				if (i==boundIndex[0]){
					res[j++] = intervals[i];
					res[j++] = newInterval;
				}else {
					res[j++] = intervals[i];
				}
			}
			return res;
		}
		// tip 2 不和任何一个范围相交， 且两端在不同的缺口，删除两个缺口之间的
		if(boundIndex[0]!=-2&&boundIndex[1]!=-2&&boundIndex[0]!=boundIndex[1]){
			res = new int[intervals.length-(boundIndex[1]-boundIndex[0]-1)][2];
			int j = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (-1==boundIndex[0]){
					while (i<boundIndex[1]) ++i;
					res[j++] = newInterval;
					boundIndex[0] = -2;
					continue;
				}
				if (i==boundIndex[0]){
					res[j++] = intervals[i];
					while (i<boundIndex[1]) ++i;
					res[j++] = newInterval;
				}else {
					res[j++] = intervals[i];
				}
			}
			return  res;
		}
		//tip3： 都落在范围内，合并两者所在的范围，且左右两个范围合二为一
		if (intersectionIndex[0]!=-2&&intersectionIndex[1]!=-2){
			if (intersectionIndex[0]==intersectionIndex[1]) return  intervals; // 落在同一个范围内，结果就是原来的结果
			res = new int[intervals.length-(intersectionIndex[1]-intersectionIndex[0])][2];
			int j = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (i==intersectionIndex[0]){
					newInterval[0] = intervals[i][0];
					while (i<intersectionIndex[1]) ++i;
					newInterval[1] = intervals[i][1];
					res[j++] = newInterval;
				}else {
					res[j++] = intervals[i];
				}
			}
			return res;
		}
		//tip4 一边落在范围内，一边落在缺口内，这种要将落在范围内的范围扩大，扩大到缺口值，中间部分还要删除
		if (boundIndex[0]!=-2&&intersectionIndex[1]!=-2){//左侧落在缺口，右侧落在范围，删除中间的，更新右侧范围的左边界
			res = new int[intervals.length-(intersectionIndex[1]-boundIndex[0]-1)][2];
			int j = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (-1==boundIndex[0]){
					while (i<intersectionIndex[1]) ++i;
					res[j] = intervals[i];
					res[j][0] = newInterval[0]; //左侧更新
					++j;
					boundIndex[0] = -2;
					continue;
				}
				if (i==boundIndex[0]){
					res[j++] = intervals[i];
					while (i<intersectionIndex[1]) ++i;
					res[j] = intervals[i];
					res[j][0] = newInterval[0]; //左侧更新
					++j;
				}else {
					res[j++] = intervals[i];
				}
			}
			return res;
		}
		if (boundIndex[1]!=-2&&intersectionIndex[0]!=-2){//左侧落在范围，右侧落在缺口，删除中间的，更新左侧范围的右边界
			res = new int[intervals.length-(boundIndex[1]-intersectionIndex[0])][2];
			int j = 0;
			for (int i = 0; i < intervals.length; i++) {
				if (i==intersectionIndex[0]){
					res[j] = intervals[i];
					res[j][1] = newInterval[1];//更新右侧
					++j;
					while (i<boundIndex[1]) ++i;
				}else {
					res[j++] = intervals[i];
				}
			}
			return res;
		}
        return null;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[][] input = {{1,5}};
		int[] newInterval = {0,6};
		int[][] output = solution.insert(input, newInterval);
		for (int[] i: output){
			System.out.println(Arrays.toString(i));
		}
	}

}
