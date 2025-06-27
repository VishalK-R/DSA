package com.leet.recursion.easy;

public class PowerOfTwo {

	/**Given an integer n, return true if it is a power of two. Otherwise, return false. 
	 * An integer n is a power of two, if there exists an integer x such that n == 2x.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(6));
	}
	
	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
	        return false;
	    }else if (n == 1) {
	        return true;
	    }else if (n % 2 == 1) {
	        return false;
	    }
		
	    return isPowerOfTwo(n / 2);
    }

}
