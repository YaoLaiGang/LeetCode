package zigZagConversion;

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
 * ①使用StringBulider类，把(i+1)/(nRows)==0的字符取出并保存
 * ②循环nRows次，第i次分别取（i+1+nRows*j）-1
 *   当i==nRows/2时,每次取一个①外，还要间隔取出①中所存储的字符串
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("ABC", 2));
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
