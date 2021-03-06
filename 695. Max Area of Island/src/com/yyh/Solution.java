package com.yyh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(my.maxAreaOfIsland(grid));
	}
	
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int res = 0;
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				if (visited[i][j] || grid[i][j] == 0) continue;
				int curCount = 0;
				Queue<Pair> queue = new LinkedList<>();
				queue.offer(new Pair(i, j));
				visited[i][j] = true;
				while (!queue.isEmpty()){
					Pair cur = queue.poll();
					curCount++;
					List<Pair> neis = getNeis(cur, row, col);
					for (Pair nei: neis){
						if (!visited[nei.x][nei.y] && grid[nei.x][nei.y] == 1){
							queue.offer(nei);
							visited[nei.x][nei.y] = true;
						}
					}
				}
				res = Math.max(curCount, res);
			}
		}
		return res;
	}

	private List<Pair> getNeis(Pair cur, int row, int col){
		int x = cur.x;
		int y = cur.y;
		List<Pair> neis = new ArrayList<>();
		if (x - 1 >= 0) neis.add(new Pair(x - 1, y));
		if (y - 1 >= 0) neis.add(new Pair(x, y - 1));
		if (x + 1 < row) neis.add(new Pair(x + 1, y));
		if (y + 1 < col) neis.add(new Pair(x, y + 1));
		return neis;
	}
}
