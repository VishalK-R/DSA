package com.leet.arrays.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	/**Given an m x n matrix, return all elements of the matrix in spiral order.
	 * 
	 */
	public static void main(String[] args) {
		int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
		spiralOrder(matrix).stream().forEach(System.out::println);

	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderMatrixList = new LinkedList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows*cols;
        int row = 0;
        int col = 0;
        int rowChange = 0;
        int colChange = 1;
        int elementsNo = 0;
        while(elementsNo<size) {
        	spiralOrderMatrixList.add(matrix[row][col]);
        	matrix[row][col]=101;
        	if((row==0&&col==cols-1)||(col==cols-1&&row==rows-1)||(col==0&&row==rows-1&&row!=0)
        			||matrix[row+rowChange][col+colChange]==101){
        		int temp = rowChange;
        		rowChange = colChange;
        		colChange = -temp;
        	}
        	row+=rowChange;
        	col+=colChange;
        	elementsNo++;
        }
        
        
        return spiralOrderMatrixList;
    }

}
