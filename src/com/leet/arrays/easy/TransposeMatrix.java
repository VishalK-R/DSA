package com.leet.arrays.easy;

import java.util.Arrays;

public class TransposeMatrix {

	/**Given a 2D integer array matrix, return the transpose of matrix.
	 * 
	 * The transpose of a matrix is the matrix flipped over its main 
	 * diagonal, switching the matrix's row and column indices.
	 * 
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6}};
		Arrays.stream(transpose(matrix)).map(Arrays::toString)
		.forEach(System.out::println);

	}
	
	public static int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				transpose[j][i] = matrix[i][j];
			}
		}
        return transpose;
    }

}
