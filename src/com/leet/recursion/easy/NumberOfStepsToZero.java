package com.leet.recursion.easy;

public class NumberOfStepsToZero {

	public static void main(String[] args) {
		System.out.println(numberOfSteps(543));
	}
	
	public static int numberOfSteps(int num) {
        if(num==0) return 0;

        if(num%2==1){
            return (1+numberOfSteps(num-1));
        }else{
            return(1+numberOfSteps(num/2));
        }
    }
}
