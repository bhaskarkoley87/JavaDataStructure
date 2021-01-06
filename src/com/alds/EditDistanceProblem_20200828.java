package com.alds;

public class EditDistanceProblem_20200828 {

	public static void main(String[] args) {
		String str1 = "geek";
		String str2 = "gesek";
		//System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
		System.out.println(Math.floor(1.5));
		
		//System.out.println(editDistance("geek", "gesek"));
	}
	
	public static int editDistance(String str1, String str2, int l1, int l2) {
		
		if(l1 == 0)
			return l2;
		 
		if(l2 == 0)
			return l1;
		
		//If the current char match, go to next
		if(str1.charAt(l1 - 1) == str2.charAt(l2 - 1))
			return editDistance(str1, str2, l1 - 1, l2 - 1);
		
		//Find the minimum no of operation required for make identical string, and add 1 to that
		return 1 + min(editDistance(str1, str2, l1, l2 - 1),//Insert
						editDistance(str1, str2, l1 - 1, l2),//Delete
						editDistance(str1, str2, l1 - 1, l2 - 1)//Replace
						);
	}
	
	public static int min(int x, int y, int z) {
		return x <= y && x <= z ? x : y <= x && y <= z ? y : z;
	}

}
