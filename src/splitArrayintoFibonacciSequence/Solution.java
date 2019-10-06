package splitArrayintoFibonacciSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 给一个数字字符串，按照前后顺序拆分为数字，组成一个数组，让这个数组组成Fibonacci数列
    * 使用回溯法(DFS),逐个查找看能否组成解
    * 需要注意的是，0只能作为单独的整数存在
    * */
    private Integer[][] memory;
    private List<Integer> fib, res;
    private int len;
    private String s;
    public List<Integer> splitIntoFibonacci(String S) {
        s = S;
        len = S.length();
        if (len<3) return null;
        memory = new Integer[len][len];
        fib = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, 1);
        return res;
    }
    public void dfs(int start, int depth){
        if (start==len){
            if (depth>3){
                res = new ArrayList<>(fib);
            }
            return;
        }
        if (depth==1||depth==2){// 前两个可以随意产生
            if (s.charAt(start)=='0'){
                memory[start][start] = 0;
                fib.add(0);
                dfs(start+1,depth+1);
                fib.remove(fib.size()-1);
            }
            else{
                for (int i = start; i < len-1 && i-start+1<=10; i++) {// 1最少留两个，2最少留一个, 注意最大值需要判定
                    if (i-start+1==10&&isOverflow(s.substring(start, i+1))){//判定是否超出整数的最大值
//                        int valid = Integer.parseInt(s.substring(start, i));//缺最后一位
//                        if (valid>214748364) continue;
//                        else if (s.charAt(i)>'7') continue;
                        continue;
                    }
                    if (memory[start][i]==null){
                        memory[start][i] = Integer.parseInt(s.substring(start, i+1));
                    }
                    fib.add(memory[start][i]);
                    dfs(i+1,depth+1);
                    fib.remove(fib.size()-1);
                }
            }
        }
        else if (depth>2){//要找到前面两个值相加的结果
            Integer added = fib.get(depth-2)+fib.get(depth-3);
            // 判定是否产生了相加溢出
            if (added<0) return;
            if (s.charAt(start)=='0'){
                memory[start][start] = 0;
                if (added==0){
                    fib.add(added);
                    dfs(start+1, depth+1);
                    fib.remove(fib.size()-1);
                }
            }else {
                int numlen = added==0? 1:(int) Math.log10(added)+1;
                if (start+numlen-1>=len) return; // 剩余元素长度无法满足
                if (numlen>10) return;
                if (numlen==10&&isOverflow(s.substring(start, start+numlen))){//判定是否超出整数的最大值
//                    int valid = Integer.parseInt(s.substring(start, start+numlen-1));//缺最后一位
//                    if (valid>214748364) return;
//                    else if (s.charAt(start+numlen-1)>'7') return;
                    return;
                }
                if (memory[start][start+numlen-1] == null) memory[start][start+numlen-1] = Integer.parseInt(s.substring(start, start+numlen));
                if (memory[start][start + numlen - 1].equals(added)) {
                    fib.add(added);
                    dfs(start+numlen, depth+1);
                    fib.remove(fib.size()-1);
                }
            }
        }
    }
    public boolean isOverflow(String s){
        // 判定这个字符串是否溢出
        String p = "2147483647";
        return s.compareTo(p)>0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.splitIntoFibonacci("417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755");
//        System.out.println(Integer.MAX_VALUE+"");
//        System.out.println(solution.isOverflow("2147483648"));

    }
}

