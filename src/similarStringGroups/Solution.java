package similarStringGroups;

public class Solution {
     /*
     * 这个题目给出了一个相似词的定义：有AB两个单词，若A变更其中两个字母的顺序和B相同，则A B 相似
     * 如果两个单词相似，那么他们可以划分为一组，现在给一组单词，问可以划分为几组？
     * 这个问题本质上是图的问题，两个单词的相似可以令其组成一条边，单词能成为一组其实就是形成了一个连通图
     * 我们可以用并查集来进行分组，最后的分组个数就是结果
     * 也可以使用普通的图的遍历，发现未被遍历到的点的个数就是分组个数
     * */
     public int numSimilarGroups(String[] A) {
         /*
         * 并查集解法，需要注意最后找根的时候不需要每个元素都要getRoot, 只要i==root[i]的就可以判定为根
         * */
         UnionFind uf = new UnionFind(A.length);
         for (int i = 0; i < A.length; i++) {
             for (int j = i + 1; j < A.length; j++) {
                 if (isSimilar(A[i], A[j])) uf.union(i, j);
             }
         }
         int n = 0;
         for (int i = 0; i < A.length; i++) {
             if (i == uf.root[i]) ++n;
         }
         return n;
     }
     public boolean isSimilar(String a, String b){
         int uneqal = 0;
         for (int i = a.length()-1; i >= 0; i--) {
             if (uneqal>2) return false;
             if (a.charAt(i)!=b.charAt(i)) ++uneqal;
         }
         if (uneqal==0) return true;
         return uneqal==2;
     }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A = {"tars","rats","arts","star","tars"};
        System.out.println(solution.numSimilarGroups(A));
    }
}

class  UnionFind{
    public int[] root;
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
    public boolean union(int p, int q){
        int rootp = getRoot(p), rootq = getRoot(q);
        if (rootp==rootq) return false;
        root[rootp] = rootq;
        return true;
    }
}