package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree, return all root-to-leaf paths.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, sb, res);
        return res;
    }
    
    public void helper(TreeNode root, StringBuilder sb, List<String> res){
        if (root == null) return;
        int len = sb.length();
        sb.append("->" + root.val);
        if (root.left == null && root.right == null){
            res.add(sb.substring(2));
            sb.setLength(len);
            return;
        }
        if (root.left != null){
            helper(root.left, sb, res);
        }
        if (root.right != null){
            helper(root.right, sb, res);
        }
        sb.setLength(len);
        return;
    }
}
