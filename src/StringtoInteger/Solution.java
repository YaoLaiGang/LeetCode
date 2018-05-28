package StringtoInteger;

import java.util.ArrayList;

/**
 * 2018年05月28日17:49:02
 * Java版atoi()
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("0-1"));
	}
    public static int myAtoi(String str) {
    	if(str==null){
    		return 0;
    	}
    	//step1 : 清除开头结尾的空格（如果有）
    	str = str.trim();
    	if(str.length()==0){
    		return 0;
    	}
    	//step2 : 判断±并取出后来的值
    	char ch,opt = str.charAt(0);
    	int len = str.length(),flag=0;
    	long m=0;
    	if(opt == '+' || opt == '-' || (opt>='0'&&opt<='9') ){
    		//将符号之后的数字暂存到LIST当中
    		ArrayList num = new ArrayList<Integer>();
    		for (int i = 0; i < len; i++) {
    			ch = str.charAt(i);
				if(ch>='0'&&ch<='9'){
					num.add(ch-'0');
				}
//				只有第一个+ - 号不统计
				else if((ch=='+'||ch=='-')&&i==0){
					continue;
				}
//				有字母就直接跳出
				else{
					break;
				}
			}
    		System.out.println(num);
//    		没有数字只有正负号的情况
    		if(num.isEmpty()){
    			return 0;
    		}
//    		对数字进行加权计算
    		else{
    			while(!num.isEmpty()){
//    				从前向后取数字，加权
    				m=m*10+(int)num.remove(0); 	
    				System.out.println("m="+m+"  arr="+num);
//    				溢出就返回溢出前的值
    				if(m>Integer.MAX_VALUE){
    					System.out.println("溢出");
    					if(opt=='-'){
    						return Integer.MIN_VALUE;
    					}
    					else{
    						return Integer.MAX_VALUE;
    					}
    				}
    				
    			}
//    			判定±，返回结果
    			return (int)(opt=='-'?-m:m);
    		}
    	}
    	else{
    		return 0;
    	}
    	
    }
}
