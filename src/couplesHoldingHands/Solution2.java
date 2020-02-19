package couplesHoldingHands;

import java.util.Arrays;

public class Solution2 {
    /*
    * 在题目的提示里我们看到了并查集（Union Find），是的，并查集也可以解决这个问题
    * 我们可以把每队情侣都看成一个集合，当两个是不是情侣但是做到了一起就将他们代表的的集合合并,实际上也就是交换了一次
    * 我们只要统计合并次数就可以解决问题
    * */
    public int minSwapsCouples(int[] row) {
        int n = 0;
        UnionFind uf = new UnionFind(row.length/2);
        for (int i = 1; i < row.length; i+=2) {
            int g1 = row[i-1]/2, g2 = row[i]/2;
            if (g1!=g2){
                if (uf.union(g1, g2)) {
                    ++n;
                }
            }
        }
//        System.out.println(Arrays.toString(uf.root));
        return n;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] input = {5,4,2,6,3,1,0,7};
        System.out.println(solution.minSwapsCouples(input));
    }
}
class UnionFind{
    private int parent[];
    public UnionFind(int n){
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
