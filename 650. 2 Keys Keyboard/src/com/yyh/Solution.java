package com.yyh;
/*
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
 * Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
 * Output the minimum number of steps to get n 'A'.
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.minSteps(6));
	}
	
	public int minSteps(int n) {
		if (n == 1){
			return 0;
		}
		int[] dp = new int[n + 1];
		dp[n] = 0;
		for (int i = n - 1; i > 0; i--){
			dp[i] = n;
			for (int j = 2; j * i <= n; j++){
				dp[i] = Math.min(dp[i], dp[i * j] + j);
			}
		}
		return dp[1];
	}
}
