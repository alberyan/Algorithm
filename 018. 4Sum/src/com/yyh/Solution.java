package com.yyh;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>(); 
		for (int i = 0; i < num.length - 3; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				for (int l = num.length - 1; l > i + 2; l--){
					if (l == num.length - 1 || (l < num.length - 1 && num[l] < num[l + 1])){
						int lo = i + 1, hi = l - 1, sum = target - num[i] - num[l];
						while (lo < hi) {
							if (num[lo] + num[hi] == sum) {
								res.add(Arrays.asList(num[i], num[lo], num[hi], num[l]));
								while (lo < hi && num[lo] == num[lo+1]) lo++;
								while (lo < hi && num[hi] == num[hi-1]) hi--;
								lo++; hi--;
							} else if (num[lo] + num[hi] < sum){
								lo++;
							} 
							else hi--;
						}
					}
				}
				
			}
		}
		return res;
	}
}
