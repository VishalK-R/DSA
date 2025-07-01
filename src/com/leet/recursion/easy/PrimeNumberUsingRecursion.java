package com.leet.recursion.easy;

public class PrimeNumberUsingRecursion {

	public static void main(String[] args) {
		System.out.println(primeNumber(10,2));
	}
	
	public static boolean primeNumber(int num, int divider) {
		if(num<divider*divider) return false;
		if (num%divider==0) return true;
		return primeNumber(num,++divider);
	}
}
