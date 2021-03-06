package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 * The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 */
public class StringIterator {
    List<Integer> list;
    int[] arr;
    int i;
    public StringIterator(String compressedString) {
        i = 0;
        list = new ArrayList<>();
        int s = 0;
        while (s < compressedString.length()){
            int c = (int)compressedString.charAt(s++);
            list.add(c);
            int sum = 0;
            while (s < compressedString.length() && compressedString.charAt(s) >= '0' && compressedString.charAt(s) <= '9'){
                sum = sum * 10 + compressedString.charAt(s) - '0';
                s++;
            }
            list.add(sum);
        }
        arr = new int[list.size()];
        for (int j = 0; j < arr.length; j++){
            arr[j] = list.get(j);
        }
    }
    
    public char next() {
        if (hasNext()){
            char c = (char)arr[i];
            arr[i + 1]--;
            if (arr[i + 1] <= 0){
                i += 2;
            }
            return c;
        } else return ' ';
    }
    
    public boolean hasNext() {
        if (i >= arr.length){
            return false;
        }
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */