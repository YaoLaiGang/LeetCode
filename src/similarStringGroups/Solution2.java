package similarStringGroups;

public class Solution2 {
    /*
    * 接上面并查集的解法，这里使用DFS解法来解决问题
    * */
    private boolean[] visited;
    private String[] A;
    public int numSimilarGroups(String[] A){
        visited = new boolean[A.length];
        this.A = A;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (!visited[i]){
                dfs(i);
                ++res;
            }
        }
        return res;
    }
    public boolean isSimilar(String a, String b){
        int uneqal = 0;
        for (int i = a.length()-1; i >= 0; i--) {
            if (uneqal>2) return false;
            if (a.charAt(i)!=b.charAt(i)) ++uneqal;
        }
        return uneqal == 0 || uneqal == 2;
    }
    public void dfs(int i){
        visited[i] = true;
        for (int j = 0; j < A.length; j++) {
            if (visited[j]) continue;
            if (isSimilar(A[i], A[j])) dfs(j);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] A = {"tars","tars","tars","rats","arts","star"};
        System.out.println(solution.numSimilarGroups(A));
    }
}
