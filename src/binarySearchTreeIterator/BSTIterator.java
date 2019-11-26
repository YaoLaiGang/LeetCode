package binarySearchTreeIterator;

import java.util.*;

public class BSTIterator {
    private ArrayList<Integer> element = new ArrayList<>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        // 使用层序遍历
        if (root==null) {
            index = -1;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p;
        queue.offer(root);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--) {
                p = queue.poll();
                element.add(p.val);
                if (p.left!=null) queue.offer(p.left);
                if (p.right!=null) queue.offer(p.right);
            }
        }
        Collections.sort(element);
    }
    /** @return the next smallest number */
    public int next() {
        return element.get(index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index >= 0 && index < element.size();
    }
}
