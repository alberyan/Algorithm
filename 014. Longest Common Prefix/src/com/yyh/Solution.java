package com.yyh;
// Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String[] strs = new String[]{"a", "abd"};
		System.out.println(my.longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length ==0){
			return "";
		}
		if (strs.length == 1){
			return strs[0];
		}
        int i = 0;
        Outer:
        while (true){
        	if (i == strs[0].length()){
        		break;
        	}
        	for (int j = 1; j < strs.length; j++){
        		if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
        			break Outer;
        		}
        	}
        	i++;
        }
        return strs[0].substring(0, i);
    }
}
