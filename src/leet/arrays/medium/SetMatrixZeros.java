package leet.arrays.medium;

import java.util.Arrays;

public class SetMatrixZeros {

	/**Given an m x n integer matrix matrix, if an element is 0, set its 
	 * entire row and column to 0's.
	 * 
	 * You must do it in place.
	 */
	public static void main(String[] args) {
		int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
		Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

	}
	
	public static void setZeroes(int[][] matrix) {
        boolean firstRowToBeUpdated = false;
        boolean firstColToBeUpdated = false;
        
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]==0) {
					if(i==0) firstRowToBeUpdated = true;
					if(j==0) firstColToBeUpdated = true;
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
        
        for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if(matrix[i][0]==0||matrix[0][j]==0) {
					matrix[i][j]=0;
				}
			}
        }
        
        
        if(firstRowToBeUpdated) {
        	for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i]=0;
			}
        }
        
        if(firstColToBeUpdated) {
        	for (int i = 0; i < matrix.length; i++) {
				matrix[i][0]=0;
			}
        }
    }

}
