package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionIII {
	// O(n) time, O(n) space
	public int longestValidParentheses(String s){
		int maxans = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		stack.offer(-1);
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == '('){
				stack.offer(i);
			} else {
				stack.poll();
				if (stack.isEmpty()){
					stack.offer(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}
}
