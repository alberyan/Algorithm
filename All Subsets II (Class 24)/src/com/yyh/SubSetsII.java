package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
	// Method 2: DFS II
	public List<String> subSetsII(String set){
		List<String> result = new ArrayList<String>();
		if (set == null){
			return result;
		}
		char[] arraySet = set.toCharArray();
		// Make sure the multi-set is sorted that we can dedup
		Arrays.sort(arraySet);
		StringBuilder sb = new StringBuilder();
		helperII(arraySet, sb, 0, result);
		return result;
	}
	
	// index: We pick the element by ascending order, "index" is the smallest index we can pick for the subset
	private void helperII(char[] set, StringBuilder sb, int index, List<String> result){
		result.add(sb.toString());
		// For the consecutive duplicate elements, we only pick the first one.
		for (int i = index; i < set.length; i++){
			if (i == index || set[i] != set[i - 1]){
				sb.append(set[i]);
				helperII(set, sb, i + 1, result);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	
}
