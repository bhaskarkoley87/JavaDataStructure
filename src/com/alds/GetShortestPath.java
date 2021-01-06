package com.alds;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetShortestPath {

	public static void main(String[] args) {
		int[][] data = {{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 }};
		List<Integer> result = new ArrayList<>();
		//result.add(data[0][0]);
		result = getShortestPath(data, result, 0, 0);
		System.out.println(result);
		Optional<Integer> rslt = result.stream().reduce((x, y) -> x+y);
		if(rslt.isPresent())
			System.out.println(rslt.get());
		
	}

	private static List getShortestPath(int[][] data, List<Integer> path, int x, int y) {
		if (x == data.length - 1 && y == data[data.length - 1].length - 1) {
			path.add(data[x][y]);
			return path;
		}
		
		path.add(data[x][y]);
		int right = 0;
		int bottom = 0;
		if ((x + 1) <= data.length - 1 && (y + 1) <= data[x].length - 1) {
			if(Math.abs(data[x+1][y] - data[x][y]) > (data[x][y+1] - data[x][y])) {
				path = getShortestPath(data, path, x, y+1);
			}else {
				path = getShortestPath(data, path, x+1, y);
			}
		}else if((x + 1) <= data.length - 1 && (y + 1) > data[x].length - 1) {
			path = getShortestPath(data, path, x+1, y);
		}else {
			path = getShortestPath(data, path, x, y+1);
		}
		
		
		
		

		return path;
	}

}
