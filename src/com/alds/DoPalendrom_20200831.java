package com.alds;

public class DoPalendrom_20200831 {

	public static void main(String[] args) {
		String str = "google";
		System.out.println(doPalendrom(str, 0, str.length() - 1));

	}
	
	public static String doPalendrom(String str, int i, int l) {
		if(i > l) 
			return str;
		
		if(str.charAt(i) == str.charAt(l))
			return doPalendrom(str, i+1, l-1);
		else {
			str = str.substring(0, i) + str.charAt(l) + str.substring(i, str.length());
			return doPalendrom(str, i+1, l);
		}		
		
	}

}
