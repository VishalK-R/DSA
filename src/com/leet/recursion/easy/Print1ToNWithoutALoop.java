package com.leet.recursion.easy;

public class Print1ToNWithoutALoop {

	public static void main(String[] args) {
		print(1, 10);
	}
	
	public static void print(int num, int target) {
		if(num>target) return;
		System.out.print(num+" ");
		print(num+1, target);
	}

}
