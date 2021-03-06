package com.yyh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2){
				if (i1.start == i2.start){
					return 0;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0){
			return res;
		}
		Interval resi = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++){
			Interval cur = intervals.get(i);
			if (cur.start > resi.end){
				res.add(new Interval(resi.start, resi.end));
				resi = cur;
			} else {
				resi.end = Math.max(resi.end, cur.end);
			}
			
		}
		res.add(resi);
		return res;
	}
}
