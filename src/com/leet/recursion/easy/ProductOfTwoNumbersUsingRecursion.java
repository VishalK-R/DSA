package com.leet.recursion.easy;

public class ProductOfTwoNumbersUsingRecursion {

	public static void main(String[] args) {
		System.out.println(product(20,30));
	}
	
	public static int product(int num1, int num2) {
		if(num1<num2) return product(num2, num1);
		if(num2==0) return 0;
		else return(num1+product(num1,--num2));
	}

}
