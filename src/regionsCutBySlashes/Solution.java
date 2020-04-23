package regionsCutBySlashes;

public class Solution {
    /*
    * 第959题，给一个N×N的格子，由1*1的方块组成，方块内存在"/""\"和""三种元素，这三种元素
    * 将图片分成了若干区域，问分开的区域个数
    * 思路：
    * 1.使用并查集，将每个区域一分为二,相邻的区域归并到一块,有斜杠的区域必然分为两块，最后求得根的输入即可
    * 2.使用DFS，将1*1方块九等分为3*3，以每个小格子为图的Node进行DFS遍历，遇到的非visited个数就是我们需要的
    * */
    public int regionsBySlashes(String[] grid) {
        int res = 0;
        int lenNode = grid.length*grid.length;
        UnionFind uf = new UnionFind(lenNode*2);
        for (int i = 0; i < lenNode; i++) {
            int c = i/grid.length, r = i%grid.length;
            if (grid[c].charAt(r)==' '){// 空格，该点的两三角为同一个root
                uf.uinon(i*2, i*2+1);
            }
            // 与右边节点合并
            if (r!=grid.length-1) uf.uinon(i*2+1, i*2+2);
            // 与下边节点合并
            if (c+1<grid.length){
                if (grid[c+1].charAt(r)==' '||grid[c+1].charAt(r)=='/'){
                    if (grid[c].charAt(r)==' '||grid[c].charAt(r)=='\\')uf.uinon((i+grid.length)*2, i*2);
                    else uf.uinon((i+grid.length)*2, i*2+1);
                }else {
                    if (grid[c].charAt(r)==' '||grid[c].charAt(r)=='\\')uf.uinon((i+grid.length)*2+1, i*2);
                    else uf.uinon((i+grid.length)*2+1, i*2+1);
                }
            }
        }
        for (int i = 0; i < uf.root.length; i++) {
            if (uf.root[i]==i)++res;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] grid = {"   ","   ","   "};
        System.out.println((new Solution()).regionsBySlashes(grid));
    }
}
class UnionFind{
    int[] root;
    public UnionFind(int n){
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }
    public int getRoot(int i){
        while (i!=root[i]){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
    public boolean uinon(int p, int q){
        int rp = getRoot(p), rq = getRoot(q);
        if (rp==rq) return false;
        root[rp] = rq;
        return true;
    }
}
