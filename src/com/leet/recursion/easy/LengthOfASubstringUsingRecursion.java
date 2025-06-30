package com.leet.recursion.easy;

public class LengthOfASubstringUsingRecursion {

	public static void main(String[] args) {
		System.out.println(findStringLength("Bingo"));
	}
	
	private static int findStringLength(String str) {
		if(str.isEmpty()) return 0;
		return (1+findStringLength(str.substring(1)));
	}

}
