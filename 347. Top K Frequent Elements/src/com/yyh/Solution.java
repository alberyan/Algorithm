package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Given a non-empty array of integers, return the k most frequent elements.
public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() == b.getValue() ? 0: a.getValue() - b.getValue()
            );
        for (Map.Entry<Integer, Integer> en : map.entrySet()){
            pq.offer(en);
            if (pq.size() > k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()){
            res.add(0, pq.poll().getKey());
        }
        return res;
    }
}
