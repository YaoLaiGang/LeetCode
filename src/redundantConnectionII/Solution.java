package redundantConnectionII;

public class Solution {
    /*
    * 这是上一个问题的进化版，将无向图变成了有向图
    * */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        QuickUnion qu = new QuickUnion(1001);
        for (int[] edge:
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