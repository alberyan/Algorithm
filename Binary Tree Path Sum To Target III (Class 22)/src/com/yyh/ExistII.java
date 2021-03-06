package com.yyh;

import java.util.HashSet;
import java.util.Set;

//Given a binary tree in which each node contains an integer number. Determine if there exists a path 
//(the path can only be from one node to itself or to any of its descendants), the sum of the numbers 
//on the path is the given target number.

public class ExistII {
	// Method 2: an O(n) solution.
	// Think about the related problem, how do you find if there is
	// a subarray sum to target value?
	// If there is an O(n) solution to the above problem, we can extend
	// it to each of the root->leaf paths of the binary tree.
	public boolean existIII(TreeNode root, int sum){
		if (root == null){
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return helperII(root, prefixSums, 0, sum);
	}
	
	private boolean helperII(TreeNode root, Set<Integer> prefixSums, int prevSum, int sum){
		prevSum += root.key;
		if (prefixSums.contains(prevSum - sum)){
			return true;
		}
		boolean needRemove = prefixSums.add(prevSum);
		if (root.left != null && helperII(root.left, prefixSums, prevSum, sum)){
			return true;
		}
		if (root.right != null && helperII(root.right, prefixSums, prevSum, sum)){
			return true;
		}
		if (needRemove){
			prefixSums.remove(prevSum);
		}
		return false;
	}
}
