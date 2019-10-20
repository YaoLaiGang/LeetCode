package symmetricTree;

import java.util.LinkedList;
import java.util.Queue;

/*
* 判断一个树是否对称
* 使用遍历比较两节点的左子节点和右子节点。右子节点和左子节点
* 递归非递归均可
* */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return travel(root.left, root.right);
    }
    private boolean travel(TreeNode root1, TreeNode root2){
        if (root1==null&&root2==null) return true;
        if (root1==null||root2==null) return false;
        if (root1.val!=root2.val) return false;
        return travel(root1.left, root2.right)&&travel(root1.right, root2.left);
    }
    private boolean travel2(TreeNode root1, TreeNode root2){
        // 非递归，使用队列， 类似层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t1, t2;
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()){
            t1 = queue.poll();
            t2 = queue.poll();
            if (t1==null||t2==null){
                if (t1==null&&t2==null){
                    continue;
                }
                return false;
            }
            if (t1.val!=t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
