package com.yyh;
/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */
public class Solution {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1){
			return;
		}
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i+1]){
			i--;
		}
		if(i >= 0) {                           // If not entirely descending
			int j = nums.length - 1;              // Start from the end
			while(nums[j] <= nums[i]) j--;           // Find rightmost first larger id j
			swap(nums, i, j);                     // Switch i and j
		}
		reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
	}

	private void reverse(int[] nums, int a, int b){
		while (a < b){
			swap(nums, a++, b--);
		}
	}

	private void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
