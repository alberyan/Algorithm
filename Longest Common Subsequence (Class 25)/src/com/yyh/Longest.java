package com.yyh;
// Find the length of longest common subsequence of two given strings.
public class Longest {
	public static void main(String[] args){
		String s = "abcde";
		String t = "cbabdfe";
		System.out.println(longest(s, t));
	}
	public static int longest(String s, String t) {
		if (s.length() == 0 || t.length() == 0){
			return 0;
		}
		int sLen = s.length();
		int tLen = t.length();
		int[][] dp = new int[sLen][tLen];
		int max = 0;
		for (int i = 0; i < sLen; i++){
			for (int j = 0; j < tLen; j++){
				if (s.charAt(i) == t.charAt(j)){
					if (i == 0 || j == 0){
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
					if (dp[i][j] > max){
						max = dp[i][j];
					}
				} else {
					if (i == 0 || j == 0){
						dp[i][j] = 0;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		return max;
	}
}
