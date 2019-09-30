package restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 解析所有可能的IP地址，这里需要熟悉IP地址的规则
    * x.y.z.w 值域[0.255],使用DFS解析所有可能的解
    * */
    private String s;
    private int len;
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        this.s = s;
        this.len = s.length();
        if (len<4||len>12) return res;
        dfs(0,0, new String(""));
        return res;
    }
    public void dfs(int depth, int start, String tempStr){//共四个地址，每个depth解析一个地址,start表示开始解析的地址
        if (start>=len) return;//后面长度不够了，无法产生有效解
        if (s.charAt(start)=='0'){// "0" 是特例，可以单独出现，独占一位，单不可以打头后面再跟数字
            if (depth==3){
                if (start==len-1) res.add(tempStr+"."+"0");
                return;
            }
            else{
                dfs(depth+1, start+1, tempStr+(depth==0?"":".")+"0");
                return;
            }
        }
        if (depth==3){//可能产生了解
            if (len-start>3) return;
            if (Integer.parseInt(s.substring(start))<=255){
                res.add(tempStr+"."+s.substring(start));
                return;
            }else {
                return;
            }
        }
        for (int i = start; i < start+3&&i<len; i++) {
            if (Integer.parseInt(s.substring(start, i+1))<=255){
                dfs(depth+1, i+1, tempStr+(depth==0?"":".")+s.substring(start, i+1));
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.restoreIpAddresses("0000");
        for (String s :
                res) {
            System.out.println("s = " + s);
        }
    }
}
