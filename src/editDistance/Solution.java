package editDistance;

public class Solution {
    /*
    * 给两个单词word1,word2。同时规定了三种基本操作
    * 1.插入一个字符
    * 2.删除一个字符
    * 3.替换一个字符
    * 使用回溯法是一种方法，回溯法对三种方法进行试探，最终求出最终解
    * 回溯法不使用记忆或者剪枝的话会超时，尤其是当单词很长的时候
    * 使用memory来记忆结果
    * */
    private int res = Integer.MAX_VALUE;
    private String word1, word2;
    private int len1, len2;
    private Integer[][] memory;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        len1 = word1.length();
        len2 = word2.length();
        memory = new Integer[len1][len2];
        return dfs(0,0);
    }
    public int dfs(int i, int j){
        if (j>=len2) {// j到头，i没到头，此时word1只能删除剩余的元素
            return len1 - i;
        }
        if (i>=len1){
            //j没到头，i到头了，此时word1只能插入剩余的单词
            return len2 - j;
        }
        if (memory[i][j]!=null) return memory[i][j];
        if (word1.charAt(i)==word2.charAt(j)){
            return dfs(i+1,j+1);//这里没有进行修改，depth表示的修改次数不应该拿来使用
        }else {
            //1.增加字符
            int a1 = dfs(i, j+1);
            //2.删除字符
            int a2 = dfs(i+1,j);
            //3.修改字符
            int a3 = dfs(i+1,j+1);
            memory[i][j] = Math.min(Math.min(a1, a2), a3)+1;
            return memory[i][j];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine");
        System.out.println(res);
    }
}
