package leet.arrays.easy;

public class DiagonalSum {
	/**
	 * Given a square matrix mat, return the sum of the matrix diagonals.
	 * 
	 * Only include the sum of all the elements on the primary diagonal and 
	 * all the elements on the secondary diagonal that are not part of the primary diagonal.
	 * 
	 */
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},
		               {4,5,6},
		               {7,8,9}};
		System.out.println(diagonalSum(mat));
	}

    public static int diagonalSum(int[][] mat) {
        if(mat.length==1)return mat[0][0];
        int diagonalSum = 0, rows = 0, i =0, j = mat.length-1;
        while(rows<mat.length) {
        	if(i==j) {
        		diagonalSum+=mat[rows][i];
        	}else{
        		diagonalSum+=mat[rows][i]+mat[rows][j];
        	}
        	rows++;
        	i++;
        	j--;
        }
        return diagonalSum;
    }
}
