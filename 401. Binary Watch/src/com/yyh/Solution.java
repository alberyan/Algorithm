package com.yyh;

import java.util.ArrayList;
import java.util.List;

// A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
// Each LED represents a zero or one, with the least significant bit on the right.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.readBinaryWatch(2).toString());
	}
	
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] time = new int[2];
        int[] hour = new int[]{8, 4, 2, 1};
        int[] min = new int[]{32, 16, 8, 4, 2, 1};
        helper(time, hour, min, res, num);
        return res;
    }
    
    private void helper(int[] time, int[] hour, int[] min, List<String> res, int num){
    	if (num == 0){
    		res.add(time[0] + ":" + String.format("%02d", time[1]));
    		return;
    	}
    	for (int i = 0; i < hour.length; i++){
    		if (hour[i] < 0) continue;
    		if (time[0] + hour[i] > 11) continue;
    		time[0] += hour[i];
    		hour[i] = -hour[i];
    		helper(time, hour, min, res, num - 1);
    		hour[i] = -hour[i];
    		time[0] -= hour[i];
    	}
    	for (int i = 0; i < min.length; i++){
    		if (min[i] < 0) continue;
    		if (time[1] + min[i] > 59) continue;
    		time[1] += min[i];
    		min[i] = -min[i];
    		helper(time, hour, min, res, num - 1);
    		min[i] = -min[i];
    		time[1] -= min[i];
    	}
    }
}
