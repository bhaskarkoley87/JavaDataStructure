package com.alds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTheLongestSubstring_20200811 {

	public static void main(String[] args) {
		String data = "aabacbebebe";		
		int k = 3;		
		Date dt = new Date();
		System.out.println(dt.getTime());
		FindTheLongestSubstring(k, data);
		Date dt2 = new Date();
		System.out.println(dt2.getTime());

	}

	public static void FindTheLongestSubstring(int k, String data) {

		List<String> listSubString = new ArrayList<>();
		StringBuilder subStringCurrent = new StringBuilder();
		StringBuilder uniqueChar = new StringBuilder();
		char[] dataAray = data.toCharArray();
		//int count = 0;
		for (int x = 0; x < dataAray.length; x++) {			
			uniqueChar = new StringBuilder();
			subStringCurrent = new StringBuilder();			
			subStringCurrent.append(dataAray[x]);
			uniqueChar.append(dataAray[x]);
			for (int y = x + 1; y < dataAray.length; y++) {
				//count++;
				/*//Code for no. of max repetition char
				 * if(uniqueChar.length() < k && uniqueChar.indexOf(String.valueOf(dataAray[y])) < 0) {
					uniqueChar.append(dataAray[y]);
				}
				
				if (uniqueChar.indexOf(String.valueOf(dataAray[y])) >= 0) {									
					subStringCurrent.append(dataAray[y]);						
				}else {
					break;
				}
				*/		
				
				if (subStringCurrent.indexOf(String.valueOf(dataAray[y])) < 0) {									
					subStringCurrent.append(dataAray[y]);						
				}else {
					break;
				}
				
			}
			listSubString.add(subStringCurrent.toString());
		}

		//System.out.println(count+ " | " +listSubString);
		String longestString = listSubString.get(0);
		for (String element : listSubString) {
	        if (element.length() > longestString.length()) {
	            longestString = element;
	        }
	    }
		System.out.println(longestString+ " : "+longestString.length());
	}

}
