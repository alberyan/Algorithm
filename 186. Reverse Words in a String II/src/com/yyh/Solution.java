package com.yyh;

import java.util.Arrays;

/*
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String s1 = "the sky is blue";
		char[] s = s1.toCharArray();
		my.reverseWords(s);
		System.out.println(Arrays.toString(s));
	}
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0){
			return;
		}
        int slow = 0;
        int fast = 0;
        while (fast < s.length){
        	if (s[fast] == ' '){
        		reverse(s, slow, fast - 1);
        		slow = fast + 1;
        	}
        	fast++;
        }
        reverse(s, slow, fast - 1);
        reverse(s, 0, fast - 1);
    }
	
	private void reverse(char[] arr, int a, int b){
		while (a < b){
			swap(arr, a++, b--);
		}
	}
	
	private void swap(char[] arr, int a, int b){
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
