package com.leet.arrays.easy;

public class CellsWithOddValues {
	/**
	 * There is an m x n matrix that is initialized to all 0's. 
	 * There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform 
	 * some increment operations on the matrix.
	 * 
	 * 
	 * For each location indices[i], do both of the following:
	 * Increment all the cells on row m.
	 * Increment all the cells on column n.
	 * 
	 * Given m, n, and matrix, return the number of odd-valued cells in the 
	 * matrix after applying the increment to all locations in indices.
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 2, n = 2;
		int [][]indices = {{1,1},{0,0}};
		System.out.println(oddCells(m, n, indices));
	}
	
	public static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
        	int row = indices[i][0];
        	int col = indices[i][1];
        	updateRow(matrix[row]);
        	updateCol(matrix,col);
		}
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]%2==1)count++;
			}
		}
        return count;
    }

	private static void updateCol(int[][] matrix, int col) {
		for(int i = 0; i<matrix.length;i++) {
			matrix[i][col]++;
		}
	}

	private static void updateRow(int[] matrix) {
		for(int i =0; i<matrix.length; i++) {
			matrix[i]++;
		}
	}

}
