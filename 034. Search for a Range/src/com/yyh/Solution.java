package com.yyh;

import java.util.Arrays;

// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{5, 7, 7, 8, 8, 8, 8, 10};
		System.out.println(Arrays.toString(my.searchRange(nums, 8)));
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[]{-1, -1};
		if (nums == null || nums.length == 0){
			return res;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right){
			int mid = left + (right - left) / 2;
			if (nums[mid] >= target){
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if (nums[left] != target){
			return res;
		}
		res[0] = left;
		right = nums.length - 1;
		while (left < right){
			int mid = left + (right - left) / 2 + 1;
			if (nums[mid] > target){
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		res[1] = right;
		return res;
	}
}
