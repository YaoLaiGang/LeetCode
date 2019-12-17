package pathSumIII;

public class Solution2 {
    /*
    * 解法二：对于一个节点，无非两种情况：以该节点开头；不以该节点开头
    * 创建两个函数:
    * dfs 函数，使用DFS搜索所有符合以root开头的满足和为sum的函数
    * pathsum 函数： 求得以root为开头，和不以root为开头所有满足sum的和
    **/
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum)+pathSum(root.right,sum);
    }
    private int dfs(TreeNode root, int sum){
        if (root==null) return 0;
        int count = 0;
        if (root.val==sum) count++;
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
