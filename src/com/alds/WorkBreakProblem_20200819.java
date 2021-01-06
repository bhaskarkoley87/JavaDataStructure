package com.alds;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

public class WorkBreakProblem_20200819 {

	public static void wordBreak(List<String> dict, String str, String out)
	{
		// if we have reached the end of the String,
		// print the output String

		if (str.length() == 0)
		{
			System.out.println(out);
			return;
		}

		for (int i = 1; i <= str.length(); i++)
		{
			// consider all prefixes of current String
			String prefix = str.substring(0, i);

			// if the prefix is present in the dictionary, add prefix to the
			// output String and recur for remaining String

			if (dict.contains(prefix)) {
				wordBreak(dict, str.substring(i), out + " " + prefix);
			}
		}
	}

	public static void main(String[] args)
	{
		// List of Strings to represent dictionary
		List<String> dict = Arrays.asList("bed", "bath", "bedbath", "and", "beyond");

		// input String
		String str = "bedbathandbeyond";
		Date dt = new Date();
		System.out.println(dt.getTime());
		wordBreak(dict, str, "");
		Date dt2 = new Date();
		System.out.println(dt2.getTime());
	}

}
