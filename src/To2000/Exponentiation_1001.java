package To2000;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Exponentiation_1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		while(in.hasNext()){
			String a = in.next();
			int b= in.nextInt();
			BigDecimal ba = new BigDecimal(a);
			BigDecimal res = ba.pow(b);
			String str = res.stripTrailingZeros().toPlainString();
			if(str.charAt(0)=='0'){str=str.substring(1);}
			System.out.println(str);
		}
		
	}

}
