package IntegertoRoman;

public class Solution {
	public static String intToRoman(int num) {
//		直接将个十百千位都存起来，可以组合成1-3999的任何数字，然后获得数字的各个位数即可
		if (num<1||num>3999) {
			return "";
		}
		String[][] ch = 
				{{"","I" ,"II" ,"III", "IV" ,"V" ,"VI", "VII" ,"VIII" ,"IX"},
				{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
				{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
				{"","M","MM","MMM"}};
		StringBuilder sBuilder = new StringBuilder("");
		sBuilder.append(ch[3][(num/1000)]);
		sBuilder.append(ch[2][(num/100)%10]);
		sBuilder.append(ch[1][(num/10)%10]);
		sBuilder.append(ch[0][(num%10)]);
		return sBuilder.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1994));
	}

}
