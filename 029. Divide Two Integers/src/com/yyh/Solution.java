package com.yyh;

public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.divide(-1010369383, -2147483648));
	}
	
	public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
        	return Integer.MAX_VALUE;
        }
        boolean pos = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) ? false : true;
        long ldividend = ((dividend > 0) ? (long)dividend : -(long)dividend);
        long ldivisor = ((divisor > 0) ? (long)divisor : -(long)divisor);
        if (ldivisor == 1){
        	return (pos) ? (int)ldividend : (int)-ldividend;
        } else {
        	int res = (int)helper(ldividend, ldivisor);
        	return (pos) ? res: -res;
        }
    }
	
	private long helper(long dividend, long divisor){
		if (dividend < divisor){
			return 0;
		}
		long cur = divisor;
		int res = 1;
		while (dividend >= cur + cur){
			cur += cur;
			res += res;
		}
		return res + helper(dividend - cur, divisor);
	}
}
