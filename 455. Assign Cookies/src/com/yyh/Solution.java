package com.yyh;

import java.util.Arrays;

/*
 * Assume you are an awesome parent and want to give your children some cookies. 
 * But, you should give each child at most one cookie. Each child i has a greed factor gi, 
 * which is the minimum size of a cookie that the child will be content with; 
 * and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, 
 * and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 */
public class Solution {
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0){
            if (g[i] <= s[j]){
                i--;
                j--;
            } else {
                i--;
            }
        }
        return s.length - 1 - j;
    }
}
