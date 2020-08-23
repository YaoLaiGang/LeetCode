package binaryTreeCounterclockwiseTraversal;

import java.util.*;

public class Solution {
    public List<Integer> CounterclockwiseTraversal(int n, List<Integer> node) {
        List<Integer> pre = new ArrayList<>(), rear = new ArrayList<>();
        int i = 0;
        while (i<n){
            int r = i+(int)Math.pow(2,i)-1;
            if (r<n){
                pre.add(node.get(i));
                if (r!=0) rear.add(node.get(r));
            }else{
                // 最后一层
                for (int j = i; j < n; j++) {
                    pre.add(node.get(j));
                }
            }
            i = r+1;
        }
        Collections.reverse(rear);
        pre.addAll(rear);
        return pre;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        if (n<1) return;
        List<Integer> pre = new ArrayList<>(), rear = new ArrayList<>(), midleaf = new ArrayList<>(), leaf = new ArrayList<>();
        int l = 0, maxLev = (int)Math.floor(Math.log(n)/Math.log(2));
        long num = 1;
        if (maxLev==0) {
            pre.add(in.nextInt());
            System.out.println(pre);
            return;
        }
        while (l<=maxLev){
            if (l==maxLev){// last lev
                for (int i = 0; i < n - Math.pow(2, maxLev) +1; i++) {
                    leaf.add(in.nextInt());
                }
                break;
            }
            pre.add(in.nextInt());
            num++;
            int lenLev = (int)Math.pow(2,l)-1;
            while (lenLev>1){
                if (2*num>n) {// 叶子节点
                    midleaf.add(in.nextInt());
                }else{
                    in.nextInt();
                }
                num++;
                lenLev--;
            }
            if (l!=0) {
                rear.add(in.nextInt());
                num++;
            }
            ++l;
        }
        Collections.reverse(rear);
        pre.addAll(leaf);
        pre.addAll(midleaf);
        pre.addAll(rear);
        System.out.println(pre);
    }
}
