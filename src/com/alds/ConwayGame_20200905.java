package com.alds;

public class ConwayGame_20200905 {

	public static void main(String[] args) {
		int row = 10;
		int col = 10;
		int[][] data = {{0,0,0,0,0,0,0,0,0,0},
						{0,0,0,1,1,0,0,0,0,0},
						{0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0},
						{0,0,0,1,1,0,0,0,0,0},
						{0,0,1,1,0,0,0,0,0,0},
						{0,0,0,0,0,1,0,0,0,0},
						{0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0,0}};
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < col; y++) {
				if(data[x][y]==1)
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.print("\n");
		}

		int[][] future = getNextGen(data, row, col);
		System.out.print("\n");
		System.out.print("\n");
		for(int x = 0; x < row; x++) {
			for(int y = 0; y < col; y++) {
				if(future[x][y]==1)
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.print("\n");
		}

	}
	
	public static int[][] getNextGen(int[][] data, int row, int col){
		int[][] future = new int[row][col];
		for(int x = 1; x < row - 1; x++) {
			for(int y = 1; y < col - 1; y++) {
				int crntVal = data[x][y];
				int nbrCnt = 0;
				for(int i = -1; i < 2; i++) {
					for(int z = -1; z < 2; z++) {
						//if(((i + x) > -1) && ((z + y) > -1) && ((z + y) < row) && ((z + y) > col))
							nbrCnt += data[i + x][z + y];
					}
				}
				
				nbrCnt -= data[x][y];
				
				if(crntVal == 1 && nbrCnt < 2) {
					future[x][y] = 0;
				}else if(crntVal == 1 &&  nbrCnt > 3) {
					future[x][y] = 0;
				}else if(crntVal == 0 && nbrCnt == 3) {
					future[x][y] = 1;
				}else {
					future[x][y] = data[x][y];
				}
			}
		}
		return future;
	}

}
