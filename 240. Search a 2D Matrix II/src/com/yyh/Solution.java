package com.yyh;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[][] matrix = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println(my.searchMatrix(matrix, 15));
	}
	static class Pair implements Comparable<Pair>{
		int i; int j; int val;
		public Pair(int i, int j, int val){
			this.i = i;
			this.j = j;
			this.val = val;
		}
		
		@Override
		public int compareTo(Pair another){
			if (this.val == another.val){
				return 0;
			}
			return this.val < another.val ? -1: 1;
		}
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target 
				|| matrix[matrix.length - 1][matrix[0].length - 1] < target){
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		minHeap.add(new Pair(0, 0, matrix[0][0]));
		while (!minHeap.isEmpty()){
			Pair cur = minHeap.poll();
			if (cur.val == target) {
				return true;
			} else if (cur.val > target){
				return false;
			}
			visited[cur.i][cur.j] = true;
			List<Pair> neis = getNeis(cur, rows, cols, matrix);
			for (Pair nei : neis){
				if (!visited[nei.i][nei.j]){
					minHeap.add(nei);
				}
			}
		}
		return false;
	}
	
	private List<Pair> getNeis(Pair cur, int rows, int cols, int[][] matrix){
		List<Pair> res = new ArrayList<>();
		if (cur.i - 1 >= 0){
			res.add(new Pair(cur.i - 1, cur.j, matrix[cur.i - 1][cur.j]));
		}
		if (cur.j - 1 >= 0){
			res.add(new Pair(cur.i, cur.j - 1, matrix[cur.i][cur.j - 1]));
		}
		if (cur.i + 1 < rows){
			res.add(new Pair(cur.i + 1, cur.j, matrix[cur.i + 1][cur.j]));
		}
		if (cur.j + 1 < cols){
			res.add(new Pair(cur.i, cur.j + 1, matrix[cur.i][cur.j + 1]));
		}
		return res;
	}
}
