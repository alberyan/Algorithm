package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, 
 * it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 */
public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len <= 10) return res;
        for (int i = 0; i + 10 <= len; i++){
            String cur = s.substring(i, i + 10);
            int curVal = map.getOrDefault(cur, 0);
            if (curVal == 1) res.add(cur);
            map.put(cur, curVal + 1);
        }
        return res;
    }
}
