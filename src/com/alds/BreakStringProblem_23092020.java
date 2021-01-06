package com.alds;

import java.util.ArrayList;
import java.util.List;

public class BreakStringProblem_23092020 {

	public static void main(String[] args) {
		String strData = "The extra spaces includes spaces put at the end of every line except the last one.";
		System.out.println(breakString(strData, 10, 0, strData.length(), new ArrayList<String>()));

	}
	
	private static List breakString(String strData, int K, int startIndx, int endIndex, List<String> result) {
		if(endIndex <= startIndx) {
			return result;
		}
		
		int lstWorkEnd = -1; 
		
		for(int x = startIndx; x < endIndex; x++) {
			if(String.valueOf(strData.charAt(x)).equalsIgnoreCase(" ")) {				
				lstWorkEnd = x;
			}
			
			if(x == (startIndx + K)) {				
				result.add(strData.substring(startIndx, lstWorkEnd));				
				break;
			}else if(x == (endIndex - 1)) {
				lstWorkEnd = endIndex;
				result.add(strData.substring(startIndx, endIndex));				
				break;
			}
			
		}
		
		
		result = breakString(strData, K, lstWorkEnd+1, endIndex, result);
		
		return result;
	}

}
