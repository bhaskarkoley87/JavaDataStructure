package com.alds;



public class SudukuSolver {

	public static void main(String[] args) {
		 int[][] board = new int[][] { 
	            { 9, 2, 0, 0, 7, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 3, 0, 0 }, 
	            { 0, 0, 0, 0, 8, 5, 4, 0, 0 }, 
	            { 0, 8, 4, 0, 0, 0, 0, 6, 0 }, 
	            { 0, 5, 0, 0, 0, 0, 8, 0, 0 }, 
	            { 0, 0, 0, 2, 1, 0, 0, 0, 0 }, 
	            { 0, 7, 0, 0, 0, 0, 9, 0, 0 }, 
	            { 0, 0, 0, 6, 0, 9, 2, 0, 5 }, 
	            { 0, 4, 0, 8, 0, 0, 0, 0, 0 } 
	        }; 
	       
	  
	        if (solveSudoku(board))  
	        { 
	            // print solution 
	            print(board, board.length); 
	        } 
	        else { 
	            System.out.println("No solution");
	        }

	}

	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		//System.out.println("row : " + row+"  ||  col : "+col);

		for (int r = 0; r < grid.length; r++) {
			if (grid[r][col] == num)
				return false;
		}

		for (int c = 0; c < grid.length; c++) {
			if (grid[row][c] == num)
				return false;
		}

		int sqrt = (int) Math.sqrt(grid.length);
		int startRow = row - row % sqrt;
		int startCol = col - col % sqrt;

		for (int x = startRow; x < startRow + sqrt; x++) {
			for (int y = startCol; y < startCol + sqrt; y++) {
				if (grid[x][y] == num)
					return false;
			}
		}
		return true;
	}

	private static boolean solveSudoku(int[][] grid) {
		int row = -1;
		int col = -1;
		boolean isEmpty = true;
		
		for(int x = 0; x < grid.length; x++) {
			for(int y = 0; y < grid.length; y++) {
				if(grid[x][y] == 0) {
					row = x;
					col = y;
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty) {
				break;
			}
		}
		
		if(isEmpty) {
			return true;
		}
		
		for(int num = 1; num <= grid.length; num++) {
			if(isSafe(grid, row, col, num)) {
				grid[row][col] = num;
				if(solveSudoku(grid)) {
					return true;
				}else {
					grid[row][col] = 0;
				}
			}
		}
		return false;
	}

	public static void print(int[][] board, int N) {

		
		for (int r = 0; r < N; r++) {
			if(r == 3 || r == 6) {
				System.out.print("---------------|------------------|----------------\n\n");
			}
			for (int d = 0; d < N; d++) {
				if(d == 3 || d == 6) {
					System.out.print("|   ");
				}
				System.out.print(board[r][d]);
				System.out.print("    ");
			}
			System.out.print("\n\n");

			if ((r + 1) % (int) Math.sqrt(N) == 0) {
				System.out.print("");
			}
		}
	}

}
