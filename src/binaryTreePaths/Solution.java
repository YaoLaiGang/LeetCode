package binaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 保存所有从根节点到叶子节点的路径，使用遍历即可
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }
    private void dfs(TreeNode root, String tmpRes){
        if (root==null) return;
        if (root.left==null&&root.right==null){// 叶子节点
            res.add(tmpRes+root.val);
        }
        dfs(root.left, tmpRes+root.val+"->");
        dfs(root.right, tmpRes+root.val+"->");
    }
}
