package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    *给定一个二叉树，想象你站在它的右边，返回你能看到的从上到下排序的节点的值。
    * 思路：
    * 1.使用层序遍历，获得每一层的最后一个点（最右点）即可
    * 2.使用深度优先遍历(根右左)，这样可以保证在每一层所访问的第一个元素肯定是该层最右侧元素，在所做深度优先遍历的时候需要添加层号
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode t;
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 1; i--) {// 全部遍历是i〉0但是这里留一个
                t = queue.poll();
                if (t.left!=null) queue.offer(t.left);
                if (t.right!=null) queue.offer(t.right);
            }
            t = queue.poll();
            res.add(t.val);
            if (t.left!=null) queue.offer(t.left);
            if (t.right!=null) queue.offer(t.right);
        }
        return res;
    }
}
