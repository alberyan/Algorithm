package com.yyh;

import java.util.Arrays;

// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
// with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
public class Solution {
	
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{1,2};
		my.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1){
			return;
		}
		int i = 0; int j = 0; int k = nums.length - 1;
		while (j <= k){
			if (nums[j] == 0){
				swap(nums, i, j);
				i++;
				j++;
			} else if (nums[j] == 1){
				j++;
			} else {
				swap(nums, j, k);
				k--;
			}
		}
	}
	
	private void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
