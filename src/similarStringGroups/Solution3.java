package similarStringGroups;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    /*
     * 接1,2这里使用BFS来实现
     * */
    private boolean[] visited;
    private String[] A;
    public int numSimilarGroups(String[] A){
        int res = 0;
        this.A = A;
        visited = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            if (!visited[i]){
                ++res;
                BFS(i);
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
    public void BFS(int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        while (!q.isEmpty()){
            for (int j = q.size(); j > 0; j--) {
                int node = q.poll();
                for (int k = 0; k < A.length; k++) {
                    if (visited[k]) continue;
                    if (isSimilar(A[node], A[k])){
                        visited[k] = true;
                        q.offer(k);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] A = {"tars","rats","arts","star", "tars"};
        System.out.println(solution.numSimilarGroups(A));
    }
}
