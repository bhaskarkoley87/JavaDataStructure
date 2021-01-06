package com.alds;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors; 

class TestClass {
	/*
	 * public static void main(String args[] ) throws Exception { InputStreamReader
	 * in= new InputStreamReader(System.in); BufferedReader input = new
	 * BufferedReader(in); int n; int k; int testNo =
	 * Integer.parseInt(input.readLine()); while(testNo --> 0){ String[] lnOne =
	 * input.readLine().split(" "); n = Integer.parseInt(lnOne[0]); k =
	 * Integer.parseInt(lnOne[1]); int high = 0; int count = 0; String sgn = ""; int
	 * countToHigh = 0; StringBuffer sb = new StringBuffer(); String data =
	 * input.readLine(); if(data.length() <= 0) break; sb.append(data);
	 * if(sb.indexOf("-")>=0) { sgn = "-"; sb = sb.replace(0, 1, ""); } int inv =
	 * Integer.parseInt(sb.toString(),2); while(true) { sb.append(sb.substring(0,
	 * 1)); sb = sb.replace(0, 1, "");
	 * 
	 * if(inv == Integer.parseInt(sgn+sb.toString(),2)) break;
	 * 
	 * count++; if(high < Integer.parseInt(sgn+sb.toString(),2)) { countToHigh =
	 * count; high = Integer.parseInt(sgn+sb.toString(),2); }
	 * 
	 * }
	 * 
	 * countToHigh = (countToHigh * k) + (k - 1);
	 * 
	 * System.out.println(countToHigh); } }
	 */

	public static void main(String args[]) throws Exception {
		//System.out.println((1 / 3));
		
		/*List<Integer> list = List.of( 1, 2, 3, 4, 5, 6 );
		List<Integer> list2 = list.stream().filter(x -> x%2 == 0).map(x -> x*x).collect(Collectors.toList());//.forEach(y -> System.out.println(y));
		System.out.println(list2);
		boolean isMatch = list.stream().filter(x -> x%2 == 0).allMatch(x -> x>2);
		System.out.println(isMatch);
		Optional<Integer> data = list.stream().reduce((x, y) -> {
			return x + y;
		}).filter(x -> x > 1);
		
		System.out.println(data.toString());*/
		
		int sqrt = (int)Math.sqrt(9); 
        int boxRowStart = 3 - 3 % sqrt; 
        int boxColStart = 0 - 0 % sqrt; 
        System.out.println("boxRowStart : "+boxRowStart+"  || boxColStart : "+boxColStart);
        System.out.println("boxRowStart : "+(boxRowStart+sqrt)+"  || boxColStart : "+(boxColStart+sqrt));
	}
}