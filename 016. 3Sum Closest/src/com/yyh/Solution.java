package com.yyh;

import java.util.Arrays;

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers. You may assume that each input would have exactly one solution.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{1,1,-1,-1,3};
		System.out.println(my.threeSumClosest(nums, -1));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++){
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k){
				int cur = nums[i] + nums[j] + nums[k];
				res = Math.abs(res - target) < Math.abs(cur - target) ? res : cur;
				if (cur > target){
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}
}
