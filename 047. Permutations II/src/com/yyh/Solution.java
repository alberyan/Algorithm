package com.yyh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a collection of distinct numbers, return all possible permutations.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{1, 1, 2};
		System.out.println(my.permuteUnique(nums).toString());
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null){
			return res;
		}
		List<Integer> cur = new ArrayList<>();
		if (nums.length == 0){
			res.add(cur);
			return res;
		}
		permute(nums, res, cur, 0);
		return res;
	}

	private void permute(int[] nums, List<List<Integer>> res, List<Integer> cur, int index){
		if (index == nums.length){
			res.add(new ArrayList<>(cur));
			return;
		}
		Set<Integer> dedup = new HashSet<>();
		for (int i = index; i < nums.length; i++){
			if (!dedup.contains(nums[i])){
				swap(nums, index, i);
				cur.add(nums[index]);
				permute(nums, res, cur, index + 1);
				swap(nums, index, i);
				cur.remove(cur.size() - 1);
				dedup.add(nums[i]);
			}
		}
	}

	private void swap(int[] nums, int a, int b){
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
