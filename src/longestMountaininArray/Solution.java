package longestMountaininArray;

public class Solution {
    /*
    * 在A数组里找Mountain，Mountain满足
    * 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    * 找到最长的Mountain，返回其长度，没有返回0
    *
    * 思路：分成上升期和下降期
    * 但是重复元素很烦人，会影响结果
    * */
    public int longestMountain(int[] A) {
        if (A.length<3) return 0;
        int res = 0, loc = 0;//count 表示重复元素个数
        boolean isUpper = true; //发现mountain之后，会变成false，然后找波谷的要求会改变
        for (int i = 1; i < A.length; i++) {
            if (isUpper){// 上升期
                if (i==A.length-1){
                    // 如果是上升期并且遇到末尾那肯定不是结果
                    break;
                }
                if (A[i]<=A[i-1]&&A[i]<A[i+1]){ // 出发的波谷
                    loc = i;
                }
                if (A[i]>A[i-1]&&A[i]>A[i+1]){
                    isUpper = false;
                }
            }else{// 下降期
                if (i == A.length-1&&A[i]<A[i-1]){// 如果是下降期，并且到达了末尾，那么其肯定是波谷
                    res = Math.max(i-loc+1, res);
                    break;
                }
                if (A[i]<A[i-1]&&A[i]<=A[i+1]){
                    if (A[i]<A[i-1]&&A[i]<=A[i+1]){ // 下降期的波谷
                        res = Math.max(i-loc+1, res);
                        --i;// 当然有可能是下一场
                        isUpper = true;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,0,2,0,2};
        System.out.println((new Solution()).longestMountain(input));
    }
}
