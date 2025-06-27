package com.leet.arrays.easy;

import java.util.Arrays;

public class ReshapeTheMatrix {

	/**
	 * In MATLAB, there is a handy function called reshape which can reshape an m x
	 * n matrix into a new one with a different size r x c keeping its original
	 * data.
	 * 
	 * You are given an m x n matrix mat and two integers r and c representing the
	 * number of rows and the number of columns of the wanted reshaped matrix.
	 * 
	 * The reshaped matrix should be filled with all the elements of the original
	 * matrix in the same row-traversing order as they were.
	 */
	public static void main(String[] args) {
		int[][] mat = { { 1, 2 }, { 3, 4 } };
		int r = 2, c = 2;
		Arrays.stream(matrixReshape(mat, r, c)).map(Arrays::toString).forEach(System.out::println);

	}

	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int matRows = mat.length;
		int matCols = mat[0].length;
		if (matRows * matCols != r * c)
			return mat;
		int[][] reshapedMatrix = new int[r][c];
		int row = 0, col = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				reshapedMatrix[i][j] = mat[row][col];
				if (col == matCols - 1) {
					row++;
					col = 0;
				} else {
					col++;
				}
			}
		}

		return reshapedMatrix;
	}

}
