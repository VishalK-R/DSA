package com.leet.binarySearch.easy;

public class ArrangeCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(1804289383));
		System.out.println(arrangeCoinsBruteforce(10));
	}

	public static int arrangeCoinsBruteforce(int n) {
        int maxStepsPossible = 1, maxCompletedStairs = 0;
        int iterations = 1, steps = 0;
        while(iterations<=n) {
        	if(steps<maxStepsPossible) {
        		steps++;
        		iterations++;
        	}else {
        		steps = 0;
        		maxStepsPossible++;
        		maxCompletedStairs++;
        	}
        }
        if(steps==maxStepsPossible) maxCompletedStairs++;
        return maxCompletedStairs;
    }
	

	/**
	 * if x is the complete stairs possible
	 * ((x)*(x+1))/2 == n
	 * x^2 + x -2n = 0
	 * using formula x = -b +or- sqrt(b^2 - 4*a*c)/2;
	 * x = (-1+sqrt(1-(4*1*(-2n))))/2;
	 * x = (-1+sqrt(1+8n))/2
	 * 
	 * @param n
	 * @return maxStepsPosible
	 */
	private static int arrangeCoins(int n) {
		//to avoid overflow convert 8 to long value so it is sent as long value
		int maxStepsPosible = (-1+getSqrt(1+8l*n))/2;
		return maxStepsPosible;
	}

	private static int getSqrt(long i) {
		long start = 0;
		long end = i;
		while(start<=end) {
			long mid = start+(end-start)/2;
			if(mid == i/mid) {
				return (int)mid;
			}else if(mid<i/mid) {
				start = mid + 1;
			}else {
				end = mid-1;
			}
		}
		return (int)end;
	}
	
	

}
