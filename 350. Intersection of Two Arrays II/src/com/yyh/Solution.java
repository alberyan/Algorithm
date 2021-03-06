package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given two arrays, write a function to compute their intersection.
public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2){
            Integer cur = map.get(i);
            if (cur != null && cur > 0){
                list.add(i);
                cur -= 1;
                map.put(i, cur);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
        	res[i] = list.get(i);
        }
        return res;
    }
}
