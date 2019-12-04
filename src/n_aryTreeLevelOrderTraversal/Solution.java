package n_aryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*
    * 对多叉树使用层序遍历,仍然采用队列策略
    * */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node n;
        while (!queue.isEmpty()){
            List<Integer> tmpres = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                n = queue.poll();
                tmpres.add(n.val);
                if (n.children!=null){
                    for (Node chil:
                            n.children) {
                        queue.offer(chil);
                    }
                }
            }
            res.add(tmpres);
        }
        return res;
    }
}
