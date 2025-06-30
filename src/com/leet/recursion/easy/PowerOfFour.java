package com.leet.recursion.easy;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(90));
	}
	
	public static boolean isPowerOfFour(int n) {
        if(n<1) return false;
        if (n==1) return true;
        if (n%4>0) return false;

        return isPowerOfFour(n/4);

    }

}
