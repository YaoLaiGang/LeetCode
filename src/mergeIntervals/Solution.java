package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
/*
 * 给一个间隔的集合，合并所有重复的间隔
 Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, 
merge them into [1,6].
由于给的二维数组不一定按第一列元素排序，所以应当先排序
 * */
	public void sort(int[][] arr, int row){
//		二维数组arr 按第row列进行排序
		Arrays.sort(arr, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				int[] one = (int[])o1, two = (int[])o2;
				if(one[row]>two[row]) return 1;
				if(one[row]<two[row]) return -1;
				return 0;
 			}
		});
	}
	public int[][] merge(int[][] intervals) {
		if (intervals.length<=1) return intervals;
		sort(intervals, 0);
		List<List<Integer>> arr = new ArrayList<>();
		for (int[] is : intervals) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i : is) {
				tmp.add(i);
			}
			arr.add(tmp);
		}
		int lenght = intervals.length;
		// 合并相邻的
		for(int i=0; i<lenght-1; ++i){
			if(arr.get(i).get(1)>=arr.get(i+1).get(0)){//合并
				int i0 = arr.get(i).get(0),i1 = arr.get(i).get(1),j0 = arr.get(i+1).get(0),j1 = arr.get(i+1).get(1);
				arr.get(i+1).set(0, Math.min(i0, j0));
				arr.get(i+1).set(1, Math.max(i1, j1));
				arr.remove(i);
				i--;
				lenght--;
			}
		}
		//转为二维数组
		intervals = new int[lenght][2];
		for(int i=0; i<lenght; ++i){
			intervals[i][0] = arr.get(i).get(0);
			intervals[i][1] = arr.get(i).get(1);
		}
        return intervals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[][] intervals = {{1,3},{2,6}};
		intervals = solution.merge(intervals);
		for (int[] is : intervals) {
			System.out.println(Arrays.toString(is));
		}
	}

}
