package com.leet.recursion.easy;

public class SumOfDigitsOfANumber {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(12345));

	}
	public static int sumOfDigits(int num) {
		if (num==0) return 0;
		return(num%10+sumOfDigits(num/10));
	}

}
