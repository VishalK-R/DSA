package com.leet.binarySearch.medium;

import java.util.Arrays;

public class SearchA2DMatrix {

	public static void main(String[] args) {
//		int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int [][] matrix = {{1,3}};
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int rowStart = 0, rowEnd = matrix.length-1;
		if(rowEnd<0) {
			return false;
		}
		int colStart = 0, colEnd = matrix[0].length-1;
		while(rowStart<=rowEnd) {
			int rowMid = rowStart + (rowEnd-rowStart)/2;
			int colMid = colStart + (colEnd-colStart)/2;
			if(matrix[rowMid][colMid]==target) {
				return true;
			}else if(target>=matrix[rowMid][0]&&
					target<=matrix[rowMid][matrix[rowMid].length-1]){
				return binarySearch(matrix[rowMid], target);
			}else if(target<=matrix[rowMid][0]) {
				return searchMatrix(Arrays.copyOfRange(matrix, 0, rowMid), 
						target);
			}else {
				return searchMatrix(Arrays.copyOfRange(matrix, rowMid+1, 
						matrix.length), target);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] nums, int target) {
		int start = 0, end  = nums.length;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(nums[mid]==target) {
				return true;
			}else if(nums[mid]<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}

}
