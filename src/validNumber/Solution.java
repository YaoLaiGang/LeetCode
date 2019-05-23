package validNumber;
/*
* 判断一个字符串是否是表示数字
* 数字包括以下几项
* Numbers 0-9
* Exponent - "e"
* Positive/negative sign - "+"/"-"
* Decimal point - "."
* 思路：有限自动机大法好
* https://leetcode.windliang.cc/leetCode-65-Valid-Number.html
* */

public class Solution {
    public boolean isNumber(String s) {
        if (s==null) return false;
        s = s.trim();
        char[] str = s.toCharArray();
        int state  = 0;//初始状态
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]+" ");
            switch (str[i]){
                case '+':
                case '-':{
                    switch (state){
                        case 0:{
                            state = 1;
                            break;
                        }
                        case 4:{
                            state = 6;
                            break;
                        }
                        default:{
                            return false;
                        }
                    }
                    break;
                }
                case '.':{
                    switch (state){
                        case 0:
                        case 1:{
                            state = 7;
                            break;
                        }
                        case 2:{
                            state = 3;
                            break;
                        }
                        default:{
                            return false;
                        }
                    }
                    break;
                }
                case 'e':{
                    switch (state){
                        case 2:
                        case 3:
                        case 8:{
                            state = 4;
                            break;
                        }
                        default:{
                            return false;
                        }
                    }
//                    System.out.println("e :"+state);
                    break;
                }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':{
                    switch (state){
                        case 0:
                        case 1:
                        case 2:{
                            state = 2;
                            break;
                        }
                        case 3:{
                            break;
                        }
                        case 8:
                        case 7:{
                            state = 8;
                            break;
                        }
                        case 4:
                        case 5:
                        case 6:{
                            state = 5;
                            break;
                        }
                        default:{
                            return false;
                        }
                    }
//                    System.out.println("num"+state);
                    break;
                }
                default:{
                    return false;
                }
            }
        }
//        System.out.println(state);
        if (state==2||state==3||state==8||state==5) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNumber("+.9"));
    }
}
