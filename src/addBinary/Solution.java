package addBinary;
/*
* 类似于addtownumber plusone,这题是add二进制数，这里的二进制数用String 表示
*
* Input: a = "11", b = "1"
Output: "100"
*
* Input: a = "1010", b = "1011"
Output: "10101"
* */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        if (a.length()<b.length()){//a长b短
            String tmp;
            tmp = a;
            a = b;
            b = tmp;
        }
        int lena = a.length()-1, lenb = b.length()-1, c = 0;//进位符
        while (lena>=0&&lenb>=0){
            int t = (a.charAt(lena)-'0')+(b.charAt(lenb)-'0')+c;
            switch (t){
                case 0:{// 0 0 0
                    c = 0;
                    res.insert(0, '0');
                    break;
                }case 1:{// 0 0 1
                    c = 0;
                    res.insert(0, '1');
                    break;
                }case 2:{// 0 1 1
                    c = 1;
                    res.insert(0, '0');
                    break;
                }case 3:{// 1 1 1
                    c = 1;
                    res.insert(0, '1');
                    break;
                }
            }
            lena--;
            lenb--;
        }
        // a 过长，给出剩下的结果
        while (lena>=0){
            int t = a.charAt(lena)-'0' + c;
            switch (t){
                case 0:{// 0 0
                    res.insert(0, '0');
                    break;
                }case 1:{// 0 1
                    c = 0;
                    res.insert(0,'1');
                    break;
                }case 2:{// 1 1
                    c = 1;
                    res.insert(0, '0');
                    break;
                }
            }
            lena--;
        }
        // 最后一个进位
        if (c == 1) res.insert(0, '1');
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("110010","10111"));
    }
}
