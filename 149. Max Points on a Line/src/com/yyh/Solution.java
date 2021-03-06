package com.yyh;

import java.util.HashMap;
import java.util.Map;

// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
class Point {
	int x;
	int y;
	Point() { 
		x = 0; 
		y = 0; 
	}
	Point(int a, int b) { 
		x = a; 
		y = b; 
	}
}

public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		Point[] points = new Point[]{new Point(), new Point(94911151,94911150), 
				new Point(94911152,94911151)};
		System.out.println(my.maxPoints(points));
	}
	
	public int maxPoints(Point[] points) {
		if (points.length <= 2) {
			return points.length;
		}
		int result = 0;
		for (int i = 0; i < points.length; i++){
			HashMap<Double, Integer> map = new HashMap<>();
			int samex = 1;
			int samep = 0;
			for (int j = 0; j < points.length; j++){
				if ((points[j].x == points[i].x) && (points[j].y == points[i].y)){
					samep++;
				} else if (points[j].x == points[i].x){
					samex++;
				} else {
					double k = (double)(points[j].y - points[i].y + 0.0) / (double)(points[j].x - points[i].x + 0.0);
					map.put(k, map.getOrDefault(k, 0) + 1);
				}
			}
			result = Math.max(result, samep);
			for (Map.Entry<Double, Integer> en : map.entrySet()){
				result = Math.max(en.getValue() + samep, result);
			}
			result = Math.max(result, samex);
		}
		return result;
	}
}
