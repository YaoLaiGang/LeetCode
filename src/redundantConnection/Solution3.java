package redundantConnection;

import java.util.HashMap;
import java.util.HashSet;

public class Solution3 {
    /*
    * 上面两种方法效率都不太高，下面我们使用并查集来解决图中存在环的问题
    * */
    public int[] findRedundantConnection(int[][] edges) {
        QuickUnion qu = new QuickUnion(1000+1); // 题目提示最多1000个节点
        for (int[] edge :
                edges) {
            if (!qu.union(edge[0], edge[1])) return edge;
        }
        return null;
    }

}
class QuickUnion{
    private int parent[];
    public QuickUnion(int n){
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
    }
    public int getRoot(int i){
        while (i != parent[i]){
            i = parent[i];
        }
        return i;
    }
    public boolean union(int p, int q){
         int rootP = getRoot(p);
         int rootQ = getRoot(q);
         if (rootP==rootQ) return false;
         parent[rootQ] = rootP;
         return true;
    }
    public boolean find(int p, int q){
        return getRoot(p)==getRoot(q);
    }
}
class WeighedQuickUnionWithPathCompression{
    /*
    * 上面并查集的优化版
    * 1. 合并集合时将小集合并入大集合，从而缓解高度太大的问题
    * 2. 使用路径亚索技术，每次查找过程中将id[i]=id[id[i]]以减少查找次数
    * */
    private int[] parent;
    private int[] size; // 保存集合的大小
    public WeighedQuickUnionWithPathCompression(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }
    public int getRoot(int i){
        while (i != parent[i]){
            parent[i]=parent[parent[i]];  // 路径压缩，快速查找
            i = parent[i];
        }
        return i;
    }
    public boolean union(int p, int q){
        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        if (rootP==rootQ) return false;
        if (size[p]>=size[q]){
            parent[rootQ] = rootP;
            size[rootP]+=size[rootQ];
        }else{
            parent[rootP] = rootQ;
            size[rootQ]+=size[rootP];
        }
        return true;
    }
    public boolean find(int p, int q){
        return getRoot(p)==getRoot(q);
    }
}