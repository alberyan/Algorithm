package com.yyh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. 
// Find the coordinates of the points that is k-th closest to <0,0,0>.

public class Closest {
	public static void main(String[] args){
		Closest my = new Closest();
		int[] a = new int[]{1, 2, 3};
		int[] b = new int[]{2, 4};
		int[] c = new int[]{1, 2};
		System.out.println(my.closest(a, b, c, 10).toString());
	}

	static class Node{
		int x;
		int y;
		int z;
		int dis;

		public Node(int x, int y, int z, int dis){
			this.x = x;
			this.y = y;
			this.z = z;
			this.dis = dis;
		}
	}

	public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		boolean[][][] visited = new boolean[a.length][b.length][c.length];
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(k * 3, new Comparator<Node>(){
			@Override
			public int compare(Node n1, Node n2){
				if (n1.dis == n2.dis){
					return 0;
				}
				return n1.dis < n2.dis ? -1: 1;
			}
		});

		Node cur = null;			
		minHeap.offer(new Node(0, 0, 0, dis(a[0], b[0], c[0])));
		visited[0][0][0] = true;
		for (int i = 1; i < k; i++){
			cur = minHeap.poll();
			if (cur.x < a.length - 1 && !visited[cur.x + 1][cur.y][cur.z]){
				minHeap.offer(new Node(cur.x + 1, cur.y, cur.z, dis(a[cur.x + 1], b[cur.y], c[cur.z])));
				visited[cur.x + 1][cur.y][cur.z] = true;
			}
			if (cur.y < b.length - 1 && !visited[cur.x][cur.y + 1][cur.z]){
				minHeap.offer(new Node(cur.x, cur.y + 1, cur.z, dis(a[cur.x], b[cur.y + 1], c[cur.z])));
				visited[cur.x][cur.y + 1][cur.z] = true;
			}
			if (cur.z < c.length - 1 && !visited[cur.x][cur.y][cur.z + 1]){
				minHeap.offer(new Node(cur.x, cur.y, cur.z + 1, dis(a[cur.x], b[cur.y], c[cur.z + 1])));
				visited[cur.x][cur.y][cur.z + 1] = true;
			}
		}
		cur = minHeap.poll();
		return Arrays.asList(a[cur.x], b[cur.y], c[cur.z]);
	}

	private int dis(int x, int y, int z){
		return x * x + y * y + z * z;
	}

}
