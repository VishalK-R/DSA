package com.leet.recursion.easy;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(90));
	}
	
	public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
	        return false;
	    }else if (n == 1) {
	        return true;
	    }else if (n % 3 > 0) {
	        return false;
	    }
		
	    return isPowerOfThree(n / 3);
    }

}
