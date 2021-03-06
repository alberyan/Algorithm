package com.yyh;
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
public class Solution {
	
	public static void main(String[] args){
		int[][] matrix = new int[][]{{1,3}};
		Solution my = new Solution();
		System.out.println(my.searchMatrix(matrix, 3));
		                           
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
			return false;
		}
		int row = binaryRow(matrix, target);
//		System.out.println(row);
		return binaryCol(matrix, target, row);
	}
	
	private int binaryRow(int[][] matrix, int target){
		int left = 0;
		int right = matrix.length - 1;
		while (left < right - 1){
			int mid = left + (right - left) / 2;
			if (matrix[mid][0] > target){
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return matrix[right][0] > target ? left : right;
	}
	
	private boolean binaryCol(int[][] matrix, int target, int row){
		int left = 0;
		int right = matrix[0].length - 1;
		while (left < right - 1){
			int mid = left + (right - left) / 2;
			if (matrix[row][mid] > target){
				right = mid;
			} else {
				left = mid;
			}
		}
		return matrix[row][left] == target || matrix[row][right] == target;
	}
	
}
