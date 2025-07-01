package com.leet.recursion.easy;

public class SumOfnaturalNumberUsingRecursion {

	public static void main(String[] args) {
		System.out.println(sumOfNaturalNumber(1));
	}

	public static int sumOfNaturalNumber(int num) {
		if (num==1) return 1;
		return (num+sumOfNaturalNumber(--num));
	}
}
