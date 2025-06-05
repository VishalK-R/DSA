package com.leet.binarySearch.medium;

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		int[]nums= {1,2,3,1,1};
		System.out.println(shipWithinDays(nums, 4));
	}
	
	public static int shipWithinDaysUsingBruteForce(int[] weights, int days) {
		int totalLoad = 0, max = 0;
		for (int i = 0; i < weights.length; i++) {
			totalLoad+=weights[i];
			max = Math.max(weights[i], max);
		}
		outer:
		while(max<=totalLoad) {
			int noOfDaysReq = 1;
			int sumOfWeights = 0;
			for (int i = 0; i < weights.length; i++) {
				if(sumOfWeights+weights[i]>max) {
					noOfDaysReq++;
					sumOfWeights=weights[i];
				}else {
					sumOfWeights+=weights[i];
				}
				if(noOfDaysReq>days) {
					max++;
					break;
				}else if(noOfDaysReq<=days && i == weights.length-1) {
					break outer;
				}
			}
		}
		return max;
	}
	
	public static int shipWithinDays(int[] weights, int days) {
		int totalLoad = 0, max = 0;
		for (int i = 0; i < weights.length; i++) {
			totalLoad+=weights[i];
			max = Math.max(weights[i], max);
		}
		while(max<=totalLoad) {
			int mid = max+(totalLoad-max)/2;
			int noOfDaysReq = 1;
			int sumOfWeights = 0;
			for (int i = 0; i < weights.length; i++) {
				if(sumOfWeights+weights[i]>mid) {
					noOfDaysReq++;
					sumOfWeights=weights[i];
				}else {
					sumOfWeights+=weights[i];
				}
			}
			if(noOfDaysReq>days) {
				max=mid+1;
			}else {
				totalLoad=mid-1;
			}
		}		
		return max;
	}

}
