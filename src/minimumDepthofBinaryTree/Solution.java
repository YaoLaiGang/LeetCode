package minimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
    * 求树的最小深度，就是从根节点开始到叶子节点最短经过的节点数
    * 这个使用多种遍历方式均可，这里使用层序遍历，比较快一点
    * */
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode t;
        while (!queue.isEmpty()){
            ++res;
            for (int i = queue.size(); i > 0; --i) {
                t = queue.poll();
                if (t.left==null&&t.right==null) return res;
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
            }
        }
        return res;
    }
}
