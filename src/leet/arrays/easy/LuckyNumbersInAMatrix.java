package leet.arrays.easy;

import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersInAMatrix {

	/**
	 * Given an m x n matrix of distinct numbers, return all lucky numbers in the
	 * matrix in any order.
	 * 
	 * A lucky number is an element of the matrix such that it is the minimum
	 * element in its row and maximum in its column.
	 * 
	 */
	public static void main(String[] args) {
		int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
		luckyNumbers(matrix).stream().forEach(System.out::println);
	}

	public static List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> luckyNumbers = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++) {
			int[] columnAndMinmumValueinRow = getColumnAndMinmumValueinRow(matrix[i]);
			boolean ifHappyElement = checkIfHappyElement(columnAndMinmumValueinRow, matrix);
			if(ifHappyElement) {
				luckyNumbers.add(columnAndMinmumValueinRow[1]);
			}
		}
		return luckyNumbers;
	}

	private static boolean checkIfHappyElement(int[] columnAndMinmumValueinRow, int[][] matrix) {
		int col = columnAndMinmumValueinRow[0];
		int element = columnAndMinmumValueinRow[1];
		for (int i = 0; i < matrix.length; i++) {
			if(element<matrix[i][col]) {
				return false;
			}
		}
		return true;

	}

	private static int[] getColumnAndMinmumValueinRow(int[] matrix) {
		int[] ar = new int[2];
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i]<max) {
				ar[0] = i;
				ar[1] = matrix[i];
				max = matrix[i];
			}
		}
		return ar;
	}

}
