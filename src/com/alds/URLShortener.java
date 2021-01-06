package com.alds;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class URLShortener {

	private static char[] set = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'l', 'k', 'j', 'h', 'g', 'f', 'd', 's', 'a', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'M', 'N', 'B', 'V', 'C', 'X', 'Z', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'P', 'O', 'I', 'U', 'Y', 'T', 'R', 'E', 'W', 'Q' , '0', '1' , '2' , '3', '4', '5', '6', '7', '8', '9'};
	private static HashMap<String, String> storage = new LinkedHashMap<String, String>();
	
	public static void main(String[] args) {
		String str1 = shorten("https://google.com/");
		String str2 = shorten("https://yahoo.com/");
		String str3 = shorten("https://geekofgeek.com/");
		System.out.println("str1 :: " +str1);
		System.out.println("str1 :: " +restore(str1));
		System.out.println("str2 :: " +str2);
		System.out.println("str2 :: " +restore(str2));
		System.out.println("str3 :: " +str3);
		System.out.println("str3 :: " +restore(str3));
		
		System.out.println("str4 :: " +restore("sdfsdf"));

	}
	
	private static String shorten(String url) {
		String strShrtUrl = "";
		Random rnd = new Random();
		String rand = String.valueOf(rnd.nextInt((999999 - 100000) + 1) + 100000);
		for(int x = 0; x < rand.length(); x++) {
			strShrtUrl += set[(int)rand.charAt(x)];
		}
		
		if(storage.containsKey(strShrtUrl)) {
			strShrtUrl = shorten(url);
		}else {
			storage.put(strShrtUrl, url);			
		}
		return strShrtUrl;
	}
	
	private static String restore(String str) {
		
		if(storage.containsKey(str)) {
			return storage.get(str);
		}else {
			return null;		
		}
		
	}

}
