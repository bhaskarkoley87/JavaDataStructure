package com.alds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class SolveListofEquation {
	static List<String> lstVarbls = List.of("q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "l", "k", "j", "h", "g",
			"f", "d", "s", "a", "z", "x", "c", "v", "b", "n", "m", "M", "N", "B", "V", "C", "X", "Z", "A", "S", "D",
			"F", "G", "H", "J", "K", "L", "P", "O", "I", "U", "Y", "T", "R", "E", "W", "Q");
	static HashMap<String, Integer> vrValues = new HashMap<>();

	public static void main(String[] args) {
		List<String> lstEqusn = List.of("y=x+1", "3=x+2", "z=y+x+a");
		//List<String> lstEqusn = List.of("y=x+1", "3=x+2", "z=y+2+4");
		solveEquation(lstEqusn);
		
		//String str = "aba";
			
		//System.out.println(IntStream.range(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1)));
		
		
	}

	public static void solveEquation(List<String> eqList) {
		int intSize = eqList.size();
		List<String> rmngEquation = new ArrayList<String>();

		for (String str : eqList) {
			//System.out.println(str);
			//System.out.println(vrValues);
			int count = 0;
			String[] crntEqsnParts = str.split("=");
			String rslt = crntEqsnParts[0];
			Integer result = null;
			if (lstVarbls.contains(rslt)) {
				if (vrValues.containsKey(rslt) && vrValues.get(rslt) != null) {
					rslt = vrValues.get(rslt).toString();
				} else {
					count++;
					vrValues.put(rslt, null);
				}
			} else {
				result = Integer.valueOf(rslt);
			}
			//System.out.println(crntEqsnParts[1]);
			String[] rmngPrt = crntEqsnParts[1].split("\\+");
			Integer sum = 0;
			String vrbl = "";
			for (String str2 : rmngPrt) {
				if (vrValues.containsKey(str2) && vrValues.get(str2) != null) {
					//System.out.println(str2+" : "+vrValues.get(str2));
					sum += vrValues.get(str2);
				} else if (lstVarbls.contains(str2)) {
					count++;
					vrbl = str2;
					vrValues.put(str2, null);
					if (count > 1) {
						rmngEquation.add(str);
						break;
					}
				} else {
					sum += Integer.valueOf(str2);
				}
			}

			if (result != null) {
				result = result > sum ? result - sum : sum - result;
			} else if (result == null && count <= 1) {
				result = sum;
			}

			if (count <= 1) {
				if (vrbl.equals(""))
					vrbl = rslt;
				vrValues.put(vrbl, result);
				//System.out.println(vrbl+" = "+result);
			}
		}

		if (rmngEquation.size() > 0 && intSize > rmngEquation.size()) {
			solveEquation(rmngEquation);
		} else {
			System.out.println(vrValues);
		}
		//System.out.println(rmngEquation);
	}

}