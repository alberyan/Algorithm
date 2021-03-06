package com.yyh;
// Given a binary array, find the maximum number of consecutive 1s in this array.
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) { 
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++){
			dp[i] = nums[i] == 1 ? dp[i - 1] + 1 : 0;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
