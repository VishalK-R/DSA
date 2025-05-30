package com.leet.binarySearch.medium;

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		int [] nums = {1,1};
		System.out.println(search(nums, 1));

	}
	
	public static boolean search(int[] nums, int target) {
		int pivot = 0;
		if(nums.length>1) {
			pivot = getPivot(nums);
		}
		if((pivot==nums.length-1)||
				(target>=nums[0]&&target<=nums[pivot])) {
			return binarySearch(nums, target, 0, pivot);
		}else if(target>=nums[pivot+1]&&target<=nums[nums.length-1]) {
			return binarySearch(nums, target, pivot+1, nums.length-1);
		}
		return false;
	}
	
	public static int getPivot(int[] nums) {
		int start = 0, end = nums.length-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			
			if((mid==nums.length-1)||(nums[mid]>nums[mid+1])) {
				return mid;
			}else if(nums[mid]==nums[start]&&nums[mid]==nums[end]) {
				if(nums[start]>nums[start+1]) {
					//as start is pivot return start
					return start;
				}
				start++;
				//since end cannot be pivot we are not checking for end
				end--;
			}else if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
		}
		return start;
	}
	
	public static boolean binarySearch(int[] nums , int target, 
			int start, int end) {
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(nums[mid]==target) {
				return true;
			}else if(nums[mid]<target){
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return false;
	}

}
