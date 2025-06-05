package com.leet.binarySearch.medium;

import java.util.Arrays;

public class FindAPeakElementII {

	public static void main(String[] args) {
		int[][]mat= {{30,41,24,11,24},{23,14,43,18,45},{44,42,5,39,41},
				{11,35,47,16,11},{30,25,18,41,45}};
		System.out.println(Arrays.toString(findPeakGrid(mat)));

	}
	
	public static int[] findPeakGrid(int[][] mat) {
		int rows = mat.length;
	    int cols = mat[0].length;
	    int left = 0, right = cols - 1;

	    while (left <= right) {
	        int midCol = left + (right - left) / 2;

	        // Find the row with the maximum element in midCol
	        int maxRow = 0;
	        for (int i = 0; i < rows; i++) {
	            if (mat[i][midCol] > mat[maxRow][midCol]) {
	                maxRow = i;
	            }
	        }

	        int curr = mat[maxRow][midCol];
	        int leftNeighbor = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
	        int rightNeighbor = (midCol + 1 < cols) ? mat[maxRow][midCol + 1] : -1;

	        if (curr > leftNeighbor && curr > rightNeighbor) {
	            return new int[]{maxRow, midCol}; // Found a peak
	        } else if (leftNeighbor > curr) {
	            right = midCol - 1; // Move to left half
	        } else {
	            left = midCol + 1; // Move to right half
	        }
	    }

	    return new int[]{-1, -1}; // Should never reach here
	}

}
