package com.yyh;

public class ZigZagConversion {
	
	public static void main(String[] args){
		ZigZagConversion my = new ZigZagConversion();
		System.out.println(my.convert("PAYPALISHIRING", 3));
	}
	
	public String convert(String s, int numRows) {
		if (s == null || s.length() <= 1 || numRows <= 1){
			return s;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i += 2 * (numRows - 1)){
			sb.append(s.charAt(i));
		}
		for (int i = 1; i < numRows - 1; i++){
			int j = i;
			while (j < s.length()){
				sb.append(s.charAt(j));
				j += 2 * (numRows - 1) - 2 * i;
				if (j >= s.length()){
					break;
				} else {
					sb.append(s.charAt(j));
					j += 2 * i;
				}
			}
		}
		for (int i = numRows - 1; i < s.length(); i += 2 * (numRows - 1)){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
