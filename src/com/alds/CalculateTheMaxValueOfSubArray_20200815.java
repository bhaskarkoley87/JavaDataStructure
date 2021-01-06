package com.alds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CalculateTheMaxValueOfSubArray_20200815 {

	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt.getTime());
		calculate();
		Date dt2 = new Date();
		System.out.println(dt2.getTime());
	

	}

	public static void calculate() {
		Integer[] data = { 10, 5, 2, 7, 8, 7, 2 };
		int k = 3;
		List<Integer> listMaxVals = new ArrayList<>();

		for (int i = 0; i <= data.length - k; i++) {
			listMaxVals.add(getMax(Arrays.copyOfRange(data, i, i + k)));
		}

		System.out.println(listMaxVals);
	}

	public static Integer getMax(Integer[] nums) {			
		List<Integer> list = Arrays.asList(nums);
		TreeSet<Integer> set = new TreeSet<Integer>(list);
		return set.last();
	}

}
