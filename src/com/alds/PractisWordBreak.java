package com.alds;

import java.util.Arrays;
import java.util.List;

public class PractisWordBreak {

	public static void main(String[] args) {
		List<String> D = Arrays.asList("this", "th", "is", "famous",
				"Word", "break", "b", "r", "e", "a", "k",
				"br", "bre", "brea", "ak", "problem");

		// input String
		String str = "Wordbreakproblem";
		wordBreak(D, str, "");
	}
	
	public static void wordBreak(List<String> D, String W, String prefix) {
		if(W.length() == 0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i = 1; i <= W.length(); i++) {
			String crtChar = W.substring(0, i);
			
			if(D.contains(crtChar)) {
				wordBreak(D, W.substring(i), prefix+" "+crtChar);
			}
		}
	}

}
