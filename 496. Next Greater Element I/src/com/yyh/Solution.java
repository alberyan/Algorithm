package com.yyh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums1 = new int[]{4, 1, 2};
		int[] nums2 = new int[]{1, 2, 3, 4};
		System.out.println(Arrays.toString(my.nextGreaterElement(nums1, nums2)));
	}
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Deque<Integer> s1 = new ArrayDeque<Integer>();
		Deque<Integer> s2 = new ArrayDeque<Integer>();
		for (int i = nums2.length - 1; i >= 0; i--){
			s1.offerLast(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++){
			Integer cur = 0;
			while ((cur = s1.pollLast()) != nums1[i]){
				s2.offerLast(cur);
			}
			s2.offerLast(cur);
			while ((cur = s1.pollLast()) != null && cur < nums1[i]){
				s2.offerLast(cur);
			}
			if (cur == null) res[i] = -1;
			else {
				res[i] = cur;
				s1.offerLast(cur);
			}
			while (!s2.isEmpty()){
				s1.offerLast(s2.pollLast());
			}
		}
		return res;
	}
}
