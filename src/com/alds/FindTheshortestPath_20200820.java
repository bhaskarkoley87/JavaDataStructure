package com.alds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FindTheshortestPath_20200820 {
	
	static int Row = 4;
	static int Col = 4;
	
	static int[] rowMoves = {-1, 0, 0, 1};
	static int[] colMoves = {0, -1, 1, 0}; 
	
	public static void main(String[] args) {
		boolean[][] metrix = { { false, false, false, false }, 
							   { true,  true, true,  false },
							   { false, false, false, false }, 
							   { false, false, false, false } };
		
		boolean mat[][] = {{ false, true,  false, false, false, false, true,  false, false, false }, 
                		   { false, true,  false, true,  false, false, false, true,  false, false }, 
                		   { false, false, false, true,  false, false, true,  false, true,  false }, 
                		   { true,  true,  true,  true,  false, true,  true,  true,  true,  false }, 
                		   { false, false, false, true,  false, false, false, true,  false, true }, 
                		   { false, true,  false, false, false, false, true,  false, true,  true }, 
                		   { false, true,  true,  true,  true,  true,  true,  true,  true,  false }, 
                		   { false, true,  false, false, false, false, true,  false, false, false }, 
                		   { false, false, true,  true,  true,  true,  false, true,  true,  false }}; 
		
		
		
		System.out.println(getNoofStepsforShortestPath(metrix, new Point(3, 0), new Point(0, 0)));
		

	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class QueueNode{
		Point p;
		int dis;
		
		public QueueNode(Point p, int dis) {
			this.p = p;
			this.dis = dis;
		}		
	}
	
	public static boolean isValid(int row, int col) {
		if(row >= 0 && row < Row && col >= 0 && col < Col)
			return true;
		else
			return false;
	}

	private static int getNoofStepsforShortestPath(boolean[][] metrix, Point start, Point end) {
			
		
		if(metrix[start.x][start.y] || metrix[end.x][end.y]) {
			return -1;
		}
		
		boolean[][] visited = new boolean[Row][Col];
		
		//Mark the first cell as visited
		visited[start.x][start.y] = true;
		
		Queue<QueueNode> q = new LinkedList<>();

		// Distance of source cell is 0
		QueueNode s = new QueueNode(start, 0);
		q.add(s); // Enqueue source cell
		
		while(!q.isEmpty()) {
			QueueNode crntNode = q.peek();
			Point crntPoint = crntNode.p;
			
			if(crntPoint.x == end.x && crntPoint.y == end.y)
				return crntNode.dis;
			
			q.remove();
			
			for(int i = 0; i < 4; i++) {
				int row = rowMoves[i] + crntPoint.x;
				int col = colMoves[i] + crntPoint.y;
				if(isValid(row, col) && !visited[row][col] && !metrix[row][col]) {
					visited[row][col] = true;
					QueueNode Adjcell = new QueueNode(new Point(row, col), crntNode.dis+1);
					q.add(Adjcell);
				}
			}
		}
			
		// Return -1 if destination cannot be reached
		return -1;
	}

}
