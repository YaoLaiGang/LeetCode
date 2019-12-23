package wordLadderII;

import java.util.*;

public class Solution {
    /*
    * 接上题，上题只是求出需要几次转换，这里要求出所有最短的转换序列，并要求出转换序列
    * 这个问题似乎使用图的DFS也可解，但是不一定是最小，而BFS首先到达的一定是最小的， 但是BFS会忽略一部分路径而导致丢失部分解
    * 即使考虑进去整个程序的速度也变得很慢，因此考虑使用DFS
    * 使用HashMap记录某个点的前一个节点，这样可以通过结果找到路径
    *
    * BFS 更多的是找到一个可行解/最优解， 而DFS更倾向于完备解，寻找所有解
    * 所以DFS的效率肯定会更低一点，我们可以将BFS和DFS配合，先用BFS计算最短长度，
    * 再使用DFS的过程中采用这一个长度来进行剪枝
    *
    * 并且，在BFS过程中，可以将复杂的图解钩转化为类似多叉树的图（按层划分），构建一个新的图
    * */
    private List<List<String>> res = new ArrayList<>();
    private String endWord;
    private List<String> wordList;
    private List<String> visited = new ArrayList<>();
    private int minSize = Integer.MAX_VALUE;
    private HashMap<String, List<String>> graph = new HashMap<>(); // 记录String对应的Node，以方便建立新图
    public int getLengthBFS(String beginWord, String endWord, List<String> wordList) {
        /*
        * 该函数使用BFS来获取最短解的路径长度，并构建一个图结构
        * */
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = beginWord.length();
        char[] chs;
        char ch;
        int n = 0;
        boolean flag = true;
        while (!q.isEmpty()&&flag){
            ++n;
            List<String> nowLevel = new ArrayList<>(q);
            for (int i = q.size(); i > 0; i--) {
                String str = q.poll();
                words.remove(str);
                graph.put(str, new ArrayList<>());
                chs = str.toCharArray();
                for (int j = 0; j < len; j++) {
                    ch = chs[j];
                    for (char k = 'a'; k <= 'z'; k++) {// 对j处字母进行替换
                        if (k==ch) continue;
                        chs[j] = k;
                        String tmp = new String(chs);
                        /*if (!flag&&!tmp.equals(endWord)) continue;*/
                        if (flag&&tmp.equals(endWord)) {
                            flag = false;
                        }
                        if (words.contains(tmp)&&!nowLevel.contains(tmp)){// 没被访问过, 且不是同层节点
                            graph.get(str).add(tmp);
                            q.offer(tmp);
                        }
                    }
                    chs[j] = ch;
                }
            }
        }
//        traceGraph();
        if (!flag) return ++n;
        return 0;
    }
    private void traceGraph(){
        List<String> n = graph.get("log");
        for (String d :
                n) {
            System.out.println(d);
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return res;
        this.minSize = getLengthBFS(beginWord, endWord, wordList);
        System.out.println(this.minSize);
        this.endWord = endWord;
        this.wordList = wordList;
        ArrayList<String> tmpRes = new ArrayList<>();
        dfs(beginWord, tmpRes);
        return res;
    }
    private void dfs(String node, List<String> path){
        path.add(node);
        if (path.size()>minSize){
            path.remove(node);
            return;
        }
        if (node.equals(endWord)){
            ArrayList<String> tmpRes = new ArrayList<>(path);
//            System.out.println(tmpRes);
            res.add(tmpRes);
            path.remove(node);
            return;
        }
        visited.add(node);
        if (graph.containsKey(node))
        {
            for (String n :
                graph.get(node)) {
            if (!visited.contains(n)) dfs(n, path);
        }
        }
        path.remove(node);
        visited.remove(node);
    }
    public static void main(String[] args) {
        String[] list = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordlist = new ArrayList<>();
        wordlist.addAll(Arrays.asList(list));
        System.out.println((new Solution()).findLadders("qa", "sq", wordlist));
    }
}
