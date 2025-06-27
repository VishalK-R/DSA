package com.leet.arrays.medium;

import java.util.Arrays;

public class SpiralMatrixII {
	/**Given a positive integer n, generate an n x n matrix filled with elements from 
	 * 1 to n2 in spiral order.
	 * 
	 */
	public static void main(String[] args) {
		int n = 4;
		Arrays.stream(generateMatrix(n)).map(Arrays::toString)
		.forEach(System.out::println);
	}
	
	public static int[][] generateMatrix(int n) {
        int[][]generatedMatrix = new int[n][n];
        int top =0, left = 0, bottom = n-1, right = n-1;
        int element = 1;
        while(top<=bottom&&left<=right) {
        	//insert elements in top row
        	for(int i = left; i <= right;i++) {
        		generatedMatrix[top][i]=element++;
        	}
        	top++;
        	//insert elements in right row
        	for(int i = top; i<=bottom; i++) {
        		generatedMatrix[i][right]=element++;
        	}
        	right--;
        	//insert elements in bottom row
        	for(int i = right; i >= left;i--) {
        		generatedMatrix[bottom][i]=element++;
        	}
        	bottom--;
        	//insert elements in left row
        	for(int i = bottom; i>=top; i--) {
        		generatedMatrix[i][left]=element++;
        	}
        	left++;
        }
        
        return generatedMatrix;
    }

}
