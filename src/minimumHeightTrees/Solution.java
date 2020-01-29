package minimumHeightTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    * 在图中寻找若干节点，使得以该节点为根组成的树高度最低
    * 首先满足这种要求的点不会超过两个，我们可以用反证法来证明这个问题，比如假如有三个，那个这三个点中必然有一个点能构成，与三个相悖
    * 我们先使用剥洋葱法，类似于拓扑排序，将图中边缘的叶子节点层层剥离，剩下的最后一个或者两个节点即为所求
    * */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }
        if (n==2){
            res.add(0);
            res.add(1);
            return res;
        }
        ArrayList<ArrayList<Integer>> neighbor = new ArrayList<>();  // 记录所有相邻节点
        for (int i = 0; i < n; i++) {
            neighbor.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            // 记录相邻信息
            neighbor.get(edges[i][0]).add(edges[i][1]);
            neighbor.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < degree.length; i++) {
//            只和一个点相连的为叶子节点
            if (degree[i]==1) queue.offer(i);
        }
        while (!queue.isEmpty()&&n>2){
            for (int i = queue.size(); i>0; --i){
                int node = queue.poll();
                // 删除该节点，并对相邻节点进行信息更改
                int nei = neighbor.get(node).get(0);
                --degree[nei];
                neighbor.get(nei).remove((Integer)node);
                if (degree[nei]<=1) queue.offer(nei);
                // 删除完毕
                --n;
            }
        }
        while (n!=0){
            --n;
            res.add(queue.poll());
        }
        return res;
    }
}
