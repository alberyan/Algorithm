package com.yyh;

public class SolutionII {
	public int majorityElement(int[] nums) {
		int res = 0;
		int count = 0;
		for (int num : nums){
			if (res == num){
				count++;
			} else if (count == 0){
				res = num;
				count++;
			} else {
				count--;
			}
		}
		return res;
	}
}
