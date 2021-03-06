package com.yyh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Num of words: n
// Avg length of word: m
// Time complexity: O(n(words) * m * m (dp scan) * m (substring) + nlgn) = O(n(m^3 + lgn))
// Space complexity: O(n) for the dictionary and preSet

public class ConcatenatedWords {
	public static void main(String[] args){
		// Use String array to store the result:["1st CW", "2nd CW", TotalNum]
		String[] res = new String[3];
		// Read words from the file into List
		List<String> words = new ArrayList<>();
		try {
			File dir = new File(".");
			File fin = new File(dir.getCanonicalPath() + File.separator + "wordsforproblem.txt");
			FileReader fileReader = new FileReader(fin);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				words.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Sort word for later dp operation and buffer
		// O(nlgn)
		words.sort(new Comparator<String>() {
			public int compare (String s1, String s2) {
				if (s1.length() == s2.length()){
					return 0;
				}
				return s1.length() < s2.length() ? -1 : 1;
			}
		});
		concatenatedWords(words, res);
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}

	private static void concatenatedWords(List<String> words, String[] res) {
		int lar = -1;
		int secLar = -1; // set 2 index to record Largest and second largest in the string
		int count = 0;
		Set<String> pre = new HashSet<>();
		for (int i = 0; i < words.size(); i++) {
			String cur = words.get(i);
			// Check concatenation and storing
			if (helper(cur, pre)) {
				count++;
				secLar = lar;
				lar = i;
			}
			pre.add(cur);
		}
		res[2] = count + "";
		res[1] = words.get(secLar);
		res[0] = words.get(lar);
	}

	// Use DP method to decide concatenation
	private static boolean helper(String cur, Set<String> pre) {
		if (pre.isEmpty()) {
			return false;
		}
		boolean[] M = new boolean[cur.length() + 1];
		M[0] = true;
		for (int i = 1; i <= cur.length(); i++) {
			// if the word is in the dictionary, done
			if (pre.contains(cur.substring(0, i))){
				M[i] = true;
				continue;
			}
			// check subproblem and check the rest of word.
			for (int j = 1; j < i; j++) {
				if (M[j] && pre.contains(cur.substring(j, i))) {
					M[i] = true;
					break;
				}
			}
		}
		return M[cur.length()];
	}
}
