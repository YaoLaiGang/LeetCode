package pascalTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>(rowIndex+1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i-1; j>0; --j){
                res.set(j, res.get(j)+res.get(j-1));
            }
            res.add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).getRow(33));
    }
}
