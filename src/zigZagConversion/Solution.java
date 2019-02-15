package zigZagConversion;

import java.util.ArrayList;

public class Solution {
/**
 * @author peter
 * @since 2018年03月28日18:31:12
 * 输入：convert("PAYPALISHIRING", 3)
 * 处理：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 输出："PAHNAPLSIIGYIR"
 * 
 * 解决方案：
 * 注意到每个元素对应的行数是一个循环的先递增又递减的数列
 * PAYPALISHIRING
 * 12321232123212
 * PAYPALISHIRING
 * 12343212343212
 * 
 * */
	public static String convert2(String s, int numRows) {
		if (numRows <=1) return s;
		int[] rows = new int[s.length()];
		char[] sc = s.toCharArray();
		StringBuilder[] aList = new StringBuilder[numRows];
		for(int i = 0; i<numRows; ++i){
			aList[i] = new StringBuilder();
		}
		int j;
		// 填充摆动数列， 其周期为2×numRows-2
		for(int i=0; i<rows.length; ++i){
			j = i % (2*numRows - 2) + 1;
			if (i <= 2*numRows-3) {
				rows[i] = j>numRows?2*numRows-j:j;
				aList[rows[i]-1].append(sc[i]);
			}else {
				rows[i] = rows[i-(2*numRows-2)];
				aList[rows[i-(2*numRows-2)]-1].append(sc[i]);
			}
		}
		for(int i = 1; i<numRows; ++i){
			aList[0].append(aList[i]);
		}
		return aList[0].toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert2("PAYPALISHIRING", 4));
	}
    public static String convert(String s, int numRows) {
        StringBuilder temp,inputAfter,result;
        String strTemp,strInputAfter;
        inputAfter = new StringBuilder();
        result = new StringBuilder();
        temp = new StringBuilder();
//        删除取出的字符
       for(int i=0,n=s.length();i<n;++i){
    	   if((i+1)%(numRows+1)!=0){
    		   inputAfter.append(s.charAt(i));
    	   }
    	   else{
    		   temp.append(s.charAt(i));
    	   }
       }
       strTemp=temp.toString();
       strInputAfter=inputAfter.toString();
//       循环输出
       for(int i=0;i<numRows;++i){
//    	   循环取出
    	   if(i!=(numRows-1)/2){
        	   for(int j=0,n=strInputAfter.length();i+numRows*j<n;++j){
        		   result.append(strInputAfter.charAt(i+numRows*j));        	    
    	   }
    	   }
//    	   每取一次还要间隔取出temp
    	   else{
    		   for(int j=0,n=strInputAfter.length();i+numRows*j<n;++j){
        		   result.append(strInputAfter.charAt(i+numRows*j));
        		   if(j<strTemp.length()){
        			   result.append(strTemp.charAt(j));
        		   }
        		   
    	   }
    	   }

       }
    	return result.toString();
    }

}
