package com.yyh;
/*
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). 
 * If there are multiple answers, return the lexicographically smallest one.
 */
public class Solution {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxSum = 0;
        int[] sum = new int[n+1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] ans = new int[3];
        for (int i = 0; i < n; i++){
        	sum[i+1] = sum[i]+nums[i];
        }
        int tot = sum[k] - sum[0];
        // DP for starting index of the left max sum interval
        for (int i = k; i < n; i++) {
            if (sum[i + 1]-sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i-1];
            }
        }
        // DP for starting index of the right max sum interval
       // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n - k] = n - k;
        tot = sum[n] - sum[n - k];
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[ i ] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
            	posRight[i] = posRight[i+1];
            }
        }
        // test all possible middle interval
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i-1], r = posRight[i + k];
            tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxSum) {
                maxSum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }
}
