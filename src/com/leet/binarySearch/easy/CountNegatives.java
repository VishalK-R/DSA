package com.leet.binarySearch.easy;

public class CountNegatives {

	public static void main(String[] args) {
		//int [][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		int [][] grid = {{-1}};
		System.out.println(countNegativesBruteForce(grid));
		System.out.println(countNegativesUsingBinarySearch(grid));
		System.out.println(countNegativesMostOptimized(grid));

	}
	/** O(n*m)
	 * 
	 * @param grid
	 * @return
	 */
	public static int countNegativesBruteForce(int[][] grid) {
        int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]<0) {
					count ++;
				}
			}
		}
        return count;
    }
	/** O(n*log m)
	 * 
	 * @param grid
	 * @return
	 */
	public static int countNegativesUsingBinarySearch(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			count+=getNegativeNumbersCount(grid[i]);
		}
       return count; 
    }
	
	private static int getNegativeNumbersCount(int[] nums) {
		int start = 0;
        int end = nums.length-1;
        while(start<=end) {
        	int mid = start+(end-start)/2;
        	if(nums[mid]<0) {
        		end = mid - 1;
        	}else {
        		start = mid + 1;
        	}
        }
		return nums.length-start;
	}

	/** O(n+m)
	 * 
	 * @param grid
	 * @return
	 */
	public static int countNegativesMostOptimized(int[][] grid) {
        int row = 0;
        int col = grid[0].length-1;
        int count = 0;
        while(row<grid.length && col>=0) {
        	if(grid[row][col]<0) {
        		count+=(grid.length-row);
        		col--;
        	}else {
        		row++;
        	}
        }
        return count;
    }

}
