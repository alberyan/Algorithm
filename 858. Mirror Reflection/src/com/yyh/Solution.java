package com.yyh;

public class Solution {

	public static void main(String[] args) {
		System.out.println(mirrorReflection(2, 1));

	}

	public static int mirrorReflection(int p, int q) {
        int n = 1;
        while ((n * q) % p != 0){
            n++;
        }
        System.out.println(n);
        System.out.println(n * p / q);
        if ((n + n * p / q) % 2 == 0) return 1;
        else if (n * p / q % 2 == 0) return 0;
        else return 2;
    }
}
