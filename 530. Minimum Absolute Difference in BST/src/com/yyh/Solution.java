package com.yyh;
// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int getMinimumDifference(TreeNode root) {
		int[] res = new int[]{Integer.MAX_VALUE};
		getMinimumDifference(root, res);
		return res[0];
	}

	private void getMinimumDifference(TreeNode root, int[] res){
		if (root == null || (root.left == null && root.right == null)){
			return;
		}
		if (root.left == null){
			int right = leftMost(root.right);
			res[0] = Math.min(res[0], right - root.val);
		} else if (root.right == null){
			int left = rightMost(root.left);
			res[0] = Math.min(res[0], root.val - left);
		} else {
			int right = leftMost(root.right);
			int left = rightMost(root.left);
			res[0] = Math.min(res[0], Math.min(right - root.val, root.val - left));
		}
		getMinimumDifference(root.left, res);
		getMinimumDifference(root.right, res);
	}
	
	private int rightMost(TreeNode root){
		if (root.right == null){
			return root.val;
		}
		return rightMost(root.right);
	}
	
	private int leftMost(TreeNode root){
		if (root.left == null){
			return root.val;
		}
		return leftMost(root.left);
	}
}
