package leet.arrays.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement {

	/**Given an array of integers nums sorted in non-decreasing order, 
	 * find the starting and ending position of a given target value.
	 * 
	 * If target is not found in the array, return [-1, -1].
	 * You must write an algorithm with O(log n) runtime complexity.
	 */
	public static void main(String[] args) {
		int [] nums = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums, 6)));

	}
	
	public static int[] searchRange(int[] nums, int target) {
        int[] indicesAr = {-1,-1};
        if (nums.length==0) return indicesAr;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while(left<=right) {
        	mid = (left+right)/2;
        	if(nums[mid]==target) {
        		indicesAr[0] = findLeftIndices(nums,target,left,mid);
        		indicesAr[1] = findRightIndices(nums,target,mid,right);
        		return indicesAr;
        	}else if(nums[mid]<target) {
        		left = mid+1;
        	}else {
        		right=mid-1;
        	}
        }
        
        return indicesAr;
    }

	private static int findRightIndices(int[] nums, int target, int left, int right) {
		int mid = 0;
		while(left<=right) {
			mid = (left+right)/2;
			if((left+right)%2==1) mid++;
			if(nums[mid]==target) {
				if(left==right) {
					return mid;
				}
				left = mid;
			}else if(nums[mid]>target) {
				right=mid-1;
			}
		}
		return -1;
	}

	private static int findLeftIndices(int[] nums, int target, int left, int right) {
		int mid = 0;
		while(left<=right) {
			mid=(left+right)/2;
			if(nums[mid]==target) {
				if (left==right) return mid;
				right=mid;
			}else if(nums[mid]<target) {
				left = mid+1;
			}
		}
		return -1;
	}

}
