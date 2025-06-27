package com.leet.recursion.easy;

public class BinarySearch {

	public static void main(String[] args) {
		int [] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums, 13));

	}

	public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int start, int end){
        if(start>end) return -1;

        int mid = start + (end-start)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]<target){
            return binarySearch(nums, target, mid+1, end);
        }else{
            return binarySearch(nums, target, start, mid-1);
        }
    }
}
