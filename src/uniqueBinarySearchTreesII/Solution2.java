package uniqueBinarySearchTreesII;


import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>(), left, right;
        if (n==0) return res;
        for (int i = 1; i <= n; i++) {
            left = dfs(1, i-1);
            right = dfs(i+1, n);
            for (TreeNode l :
                    left) {
                for (TreeNode r :
                        right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return  res;
    }
    public List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>(), left, right;
        if (start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            left = dfs(start, i-1);
            right = dfs(i+1, end);
            for (TreeNode l :
                    left) {
                for (TreeNode r :
                        right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return  res;
    }
}
