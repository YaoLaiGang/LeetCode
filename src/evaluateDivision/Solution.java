package evaluateDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    /*
    * 方程以A / B = k的格式给出，
    * 其中A和B是表示为字符串的变量，k是实数（浮点数）。 给定一些查询，返回答案。 如果答案不存在，则返回-1.0。
    *
    * 举个栗子：
    * 输入： a / b = 2.0, b / c = 3.0.
    * 问： a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    * 求得： [6.0, 0.5, -1.0, 1.0, -1.0 ].
    *
    * 思路：
    * 本质上是有向加权图的遍历问题，遵循如下规则：
    * 反向的结果是将权重取倒数
    * 跨过多个点结果累乘
    *
    * 注意：
    * 0做分母，但是本题不会询问这种问题
    * */
    HashMap<String, Node> nodes; // 所有点的存储地
    HashMap<String, Boolean> visited; // 所有点的访问记录
    boolean isEnd;
    Double r;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        nodes = new HashMap<>();
        visited = new HashMap<>();
        double[] res = new double[queries.size()];
        int i = 0;
        for (List<String> edge :
                equations) {
            String from = edge.get(0), to = edge.get(1);
            if (!nodes.containsKey(from)) nodes.put(from, new Node(from, new HashMap<>()));
            if (!nodes.containsKey(to)) nodes.put(to, new Node(to, new HashMap<>()));
            nodes.get(from).neighbor.put(to, values[i]);
            nodes.get(to).neighbor.put(from, 1.0/values[i++]);
            visited.put(from, false);
            visited.put(to, false);
        }
        i = 0;
        for (List<String> que :
                queries) {
            String from = que.get(0), to = que.get(1);
            if (!nodes.containsKey(from)||!nodes.containsKey(to)) res[i++] = -1;
            else if (from.equals(to)){
                res[i++]=1;
            }
            else {
                isEnd = false;
                dfs(nodes.get(from), nodes.get(to), 1.0);
                if (!isEnd) res[i++] = -1.0; //未找到相应的路径
                else res[i++] = r;
            }
        }
        return res;
    }
    private void dfs(Node from, Node to, double tmpRes){
        if (isEnd){
            visited.put(from.val, false);
            return;
        }
        visited.put(from.val, true);
        for (String next :
                from.neighbor.keySet()) {
            if (visited.get(next)) continue;
            double nextRes = tmpRes * from.neighbor.get(next);
            if (next.equals(to.val)) {
                visited.put(from.val, false);
                r = nextRes;
                isEnd = true;
                return;
            }else {
                dfs(nodes.get(next), to, nextRes);
            }
        }
        visited.put(from.val, false);
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        double[] values = {1.0, 1.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"));
        System.out.println(Arrays.toString((new Solution()).calcEquation(equations, values, queries)));
    }
}
