package leet.arrays.medium;

import java.util.Arrays;

public class SpiralMatrixIII {
	
	
	/**You start at the cell (rStart, cStart) of an rows x cols grid facing east. 
	 * The northwest corner is at the first row and column in the grid, and the southeast 
	 * corner is at the last row and column.
	 * 
	 */
	public static void main(String[] args) {
		int rows = 5, cols = 6, rStart = 1, cStart = 4;
		Arrays.stream(spiralMatrixIII(rows, cols, rStart, cStart)).map(Arrays::toString)
		.forEach(System.out::println);

		
	}
	
	public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int [][] spiralMatrix = new int[rows*cols][2];
        int element = 0;
        int restrictValue = 1;
        addIndicesToSpiralMatrix(rStart, cStart, spiralMatrix, element++);
        while(element<rows*cols) {

        	//insert top row
        	int count = 1;
        	while(count<=restrictValue) {
        		cStart++;
        		if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols) {
        			addIndicesToSpiralMatrix(rStart, cStart, spiralMatrix, element++);
        		}
        		count++;
        	}

        	//insert right col
        	count = 1;
        	while(count<=restrictValue) {
        		rStart++;
        		if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols) {
        			addIndicesToSpiralMatrix(rStart, cStart, spiralMatrix, element++);
        		}
        		count++;
        	}
        	restrictValue++;

        	//insert bottom row
        	count = 1;
        	while(count<=restrictValue) {
        		cStart--;
        		if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols) {
        			addIndicesToSpiralMatrix(rStart, cStart, spiralMatrix, element++);
        		}
        		count++;
        	}
        	
        	//insert left col
        	count = 1;
        	while(count<=restrictValue) {
        		rStart--;
        		if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols) {
        			addIndicesToSpiralMatrix(rStart, cStart, spiralMatrix, element++);
        		}
        		count++;
        	}
        	restrictValue++;
        }
        
        return spiralMatrix;
    }

	private static void addIndicesToSpiralMatrix(int rStart, int cStart, int[][] spiralMatrix,
			int element) {
		int [] indexAr = {rStart, cStart};
		spiralMatrix[element]=indexAr;
	}

}
