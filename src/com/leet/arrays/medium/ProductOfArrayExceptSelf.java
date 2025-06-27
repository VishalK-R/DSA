package com.leet.arrays.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	/**Given an integer array nums, return an array answer such that answer[i] is equal 
	 * to the product of all the elements of nums except nums[i].
	 * 
	 * 
	 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	 * 
	 * You must write an algorithm that runs in O(n) time and without using the 
	 * division operation.
	 */
	public static void main(String[] args) {
		int[] nums= {-1,1,0,-3,3};
		Arrays.stream(productExceptSelf(nums)).forEach(System.out::println);

	}
	
	public static int[] productExceptSelf(int[] nums) {
        int[] productArray = new int[nums.length];
        Arrays.fill(productArray, 1);
        int prefixProduct = 1;
        for (int i = 1; i < nums.length; i++) {
        	prefixProduct*=nums[i-1];
        	productArray[i]=prefixProduct;
		}
        
        int suffixProduct = 1;
        for (int i = nums.length-2; i >= 0; i--) {
        	suffixProduct*=nums[i+1];
        	productArray[i]*=suffixProduct;
		}
        
        return productArray;
    }

}
