package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public HashMap<Integer, Integer> tmpres = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0);
        return new ArrayList<>(tmpres.values());
    }
    public void dfs(TreeNode root, int depth){
        if (root==null) return;
        if (!tmpres.containsKey(depth)){
            tmpres.put(depth, root.val);
        }
        dfs(root.left, depth+1);
        dfs(root.right,depth+1);
    }
}
