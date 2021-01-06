package com.alds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		List<String> list = List.of("Clinic", "Hospital", "Dawakhana");
		System.out.println(getAllCombination(list));
	}
	
	public static List getAllCombination(List<String> data) {
		List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		for(String str : data) {
			/*for(List<String> crnt : result) {
				crnt.add(str);
				result.add(crnt);
			}*/
			result.addAll((Collection)result.stream().map(l -> addToList(new ArrayList(l), str)).collect(Collectors.toList()));
			//List<Boolean> crntList = result.stream().map(l -> l.add(str)).collect(Collectors.toList());
			
			ArrayList<String> nList = new ArrayList<>();
			nList.add(str);
			result.add(nList);
		}
		
		return result;
	}
	
	private static List addToList(List<String> list, String str) {
		list.add(str);
		return new ArrayList<>(list);
	}

}
