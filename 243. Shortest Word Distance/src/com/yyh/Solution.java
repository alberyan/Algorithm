package com.yyh;
// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		String[] words = new String[]{"this","is","a","long","sentence","is","fun","day","today","sunny","weather","is","a","day",
				"tuesday","this","sentence","run","running","rainy"};
		System.out.println(my.shortestDistance(words, "sentence", "a"));
	}
	
	public int shortestDistance(String[] words, String word1, String word2) {
        int index = 0;
        int res = Integer.MAX_VALUE;
        int flag = 0;
        int last = 0;
        while (index < words.length){
            if (words[index].equals(word1)){
                if (flag == 0){
                    flag = 1;
                    last = index;
                } else if (flag == 1){
                    last = index;
                } else {
                    flag = 1;
                    res = Math.min(res, index - last);
                    last = index;
                }
            }
            if (words[index].equals(word2)){
                if (flag == 0){
                    flag = 2;
                    last = index;
                } else if (flag == 1){
                    flag = 2;
                    res = Math.min(res, index - last);
                    last = index;
                } else {
                    last = index;
                }
            }
            index++;
        }
        return res;
    }
}
