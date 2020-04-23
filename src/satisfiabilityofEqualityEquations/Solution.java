package satisfiabilityofEqualityEquations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
    * 问题定义：给一组等式, 是a==b或者a!=b两种形式，变量名可变但是长度不变
    * 现在问题是问是否满足一个对变量的赋值使得所有等式成立
    * 例如： ["a==b","b!=a"] 这种就不成立
    *
    * 思路：使用并查集, 先处理所有相等的等式，相等的就把左右端合并到同一个集合，然后判定不等的是否真的不等
    * */
    public boolean equationsPossible(String[] equations) {
        ArrayList<String> unequations = new ArrayList<>(), equat = new ArrayList<>(); // 存储不等式备用
        for (int i = 0; i < equations.length; i++) {
            String e = equations[i];
            if (e.charAt(1)=='!') unequations.add(e);
            else equat.add(e);
        }
        UnionFind uf = new UnionFind(26);
        for (String str :
                equat) {
            uf.union(str.charAt(0)-'a', str.charAt(3)-'a');
        }
        for (String str :
                unequations) {
            // 如果不相等但是结果是两者具有相等的等式，那么这个公式无法实现
            if (uf.find(str.charAt(0)-'a', str.charAt(3)-'a')) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"f==a","a==b","f!=e","a==c","b==e","c==f"};
        System.out.println((new Solution()).equationsPossible(equations));
    }
}
class UnionFind{
    int[] root;
    public UnionFind(int n){
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }
    public int getRoot(int i){
        while (i!=root[i]){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
    public boolean find(int p, int q){
        return getRoot(p)==getRoot(q);
    }
    public boolean union(int p, int q){
        int rootP = getRoot(p), rootQ = getRoot(q);
        if (rootP==rootQ) return false;
        root[rootP] = rootQ;
        return true;
    }
}