package com.leet.recursion.easy;

public class FindFirstUpperCaseLetterInAString {

	public static void main(String[] args) {
		System.out.println(returnFirstUpperCaseLetter("geekS", 1));

	}
	
	public static char returnFirstUpperCaseLetter(String str,int length) {
		if(length>str.length()) return '0';
		
		if(str.charAt(length-1)>64&&str.charAt(length-1)<91) 
			return str.charAt(length-1);
		
		return returnFirstUpperCaseLetter(str, length+1);
		
	}
}
