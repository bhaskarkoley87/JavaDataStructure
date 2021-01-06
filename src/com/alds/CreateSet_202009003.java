package com.alds;

import java.util.ArrayList;
import java.util.List;

public class CreateSet_202009003 {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4 }; //2^4 = 16
		/*List<int[]> list = new ArrayList<>();
		list = funtion1(data, list);
		for (int[] data1 : list) {
			System.out.print("[");
			for (int e : data1) {
				System.out.print(e + ", ");
			}
			System.out.print("]\n");
		}*/
		
		
		
		printPowerSet(data, data.length);

	}

	public static List<int[]> funtion1(int[] data, List<int[]> list) {
		list.add(new int[0]);
		for (int x = 0; x < data.length; x++) {
			int elmnt = data[x];
			int[] elmts = { elmnt };
			list.add(elmts);
			if ((x + 1) < data.length) {
				list = function2(elmnt, x + 1, data.length - 1, data, list);
			}

		}
		return list;
	}

	private static List<int[]> function2(Integer elmnt, int i, int j, int[] data, List<int[]> list) {
		if (i == j) {
			int[] elmts = { elmnt, data[i] };
			list.add(elmts);
			return list;
		}

		List<Integer> brkQueqe = new ArrayList<>();
		for (int y = i; y <= j; y++) {
			if (!brkQueqe.isEmpty()) {
				int[] elmts = new int[brkQueqe.size() + 2];
				elmts[0] = elmnt;
				int z = 0;
				for (; z < brkQueqe.size(); z++) {
					elmts[z + 1] = brkQueqe.get(z);
				}
				brkQueqe.add(data[y]);
				elmts[z + 1] = data[y];
				list.add(elmts);
			} else {
				int[] elmts = { elmnt, data[y] };
				brkQueqe.add(data[y]);
				list.add(elmts);
			}

		}
		list = function2(elmnt, i + 1, j, data, list);

		return list;
	}

	static void printPowerSet(int[] set, int set_size) {

		/*
		 * set_size of power set of a set with set_size n is (2**n -1)
		 */
		long pow_set_size = (long) Math.pow(2, set_size);
		int counter, j;

		/*
		 * Run from counter 000..0 to 111..1
		 */
		for (counter = 0; counter < pow_set_size; counter++) {
			
			for (j = 0; j < set_size; j++) {
				/*
				 * Check if jth bit in the counter is set If set then print jth element from set
				 * true && true = true
				 * true & true = true
				 * a = 60, b = 13
				 * 
				 * (a == 3 && b == 10) = false
				 * 111100
				 * 001101
				 * ------
				 * 001100 = 12
				 * 
				 * 0001(1) -- 0
				 * 0010(2) -- 1
				 * 0100(4) -- 2
				 * 1000(8) -- 3
				 */
				
				if ((counter & (1 << j)) > 0)
					System.out.print(set[j]);
				
				
			}
			
			System.out.println();
		}
	}
}
//{1, 2, 3, 4}

/*
 *0- 0000
 *--------1- 0001
 *--------2- 0010
 *3- 0011
 *--------4- 0100
 *5- 0101
 *6- 0110
 *7- 0111
 *--------8- 1000
 *9- 1001
 *10- 1010
 *11- 1011
 *12- 1100
 *13- 1101
 *14- 1110
 *15- 1111
 *16- 10000
 *17- 10001
 *18- 10010
 *19- 10011
 *20- 10100
 */
/* 
0 (0000) -> 0			-> null
1 (0001) -> 1			-> 0
2 (0010) -> 2			-> 1
3 (0011) -> 1, 2		-> 0, 1
4 (0100) -> 4			-> 2
5 (0101) -> 1, 4		-> 0, 2
6 (0110) -> 2, 4		-> 1, 2
7 (0111) -> 1, 2, 4		-> 0, 1, 2
8 (1000) -> 8			-> 3
9 (1001) -> 1, 8		-> 0, 3
10(1010) -> 2, 8		-> 1, 3
11(1011) -> 1, 2, 8		-> 0, 1, 3
12(1100) -> 4, 8		-> 2, 3
13(1101) -> 1, 4, 8		-> 0, 2, 3
14(1110) -> 2, 4, 8		-> 1, 2, 3
15(1111) -> 1, 2, 4, 8	-> 0, 1, 2, 3
*/
