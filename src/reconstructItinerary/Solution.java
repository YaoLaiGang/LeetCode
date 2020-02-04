package reconstructItinerary;

import java.util.*;

public class Solution {
    /*
    * 给一串行程, 以[from, to]的形式表示，将这一组行程首位相接串起来成为一套完整的流程
    * 如果有多条路线，使用字典序最小的那个
    * 这个问题比较特殊，要将图中所有的边走一遍，而不是点
    * 这个问题本质上是找一条欧拉迹，欧拉迹就是包含所有边的一条路径，并且该路径所有的边都会且仅会出现一次
    * 使用Hierholzer算法来寻找欧拉迹
    * 从一个可能的起点出发，进行深度优先搜索，但是每次沿着辅助边从某个顶点移动到另外一个顶点的时候，
    * 都需要删除这个辅助边。如果没有可移动的路径，则将所在结点加入到栈中，并返回。
    * */
    private LinkedList<String> res = new LinkedList<>();
    private HashMap<String, LinkedList<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        // 使用HashMap来存储路径
        // 将结果填入HashMap
        for (List<String> list :
                tickets) {
            String from = list.get(0), to = list.get(1);
            map.computeIfAbsent(from, k -> new LinkedList<>());
            map.get(from).add(to);
        }
        // 对List进行排序
        for (Map.Entry<String, LinkedList<String>> entry:
        map.entrySet()){
            LinkedList<String> value = entry.getValue();
            if (value==null) continue;
            Collections.sort(value);
            map.put(entry.getKey(), value);
        }
        dfs("JFK");
        return res;
    }
    private void dfs(String node){
        LinkedList<String> search = map.get(node);
        if (search==null) {
            res.addFirst(node);
            return;
        }
        while (!search.isEmpty()){
            String next = search.removeFirst();
            dfs(next);
        }
        res.addFirst(node);
    }

    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(Arrays.asList("JFK","SFO"), Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"), Arrays.asList("ATL","JFK"), Arrays.asList("ATL","SFO"));
        System.out.println((new Solution()).findItinerary(input));
    }
}
