package com.leet.recursion.easy;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		char [] s = {};
		reverseString(s);
		System.out.println(Arrays.toString(s));

	}
	
	public static void reverseString(char[] s) {
        swap(s, 0, s.length-1);
    }

    public static void swap(char[] s, int start, int end){
        if(start>=end) return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(s, ++start, --end);
    }

}
