package com.yyh;
/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String word1 = "abcd";
		String word2 = "bc";
		System.out.println(my.minDistance(word1, word2));
	}
	
	public int minDistance(String word1, String word2) {
		if (word1.length() == 0){
			return word2.length();
		}
		if (word2.length() == 0){
			return word1.length();
		}
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i < dp.length; i++){
			dp[i][0] = i;
		}
		for (int j = 1; j < dp[0].length; j++){
			dp[0][j] = j;
		}
		for (int i = 0; i < word1.length(); i++){
			for (int j = 0; j < word2.length(); j++){
				if (word1.charAt(i) == word2.charAt(j)){
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
