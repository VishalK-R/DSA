package leet.array.hard;

public class CheckIfGoodArray {
	/**
	 * 
	 * Given an array nums of positive integers. Your task is to select some subset of 
	 * nums, multiply each element by an integer and add all these numbers. The array 
	 * is said to be good if you can obtain a sum of 1 from the array by any possible 
	 * subset and multiplicand.
	 * 
	 * Return True if the array is good otherwise return False.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int [] nums = {12,3};
		System.out.println(isGoodArray(nums));

	}
	/**
	 * Bézout's Lemma tells us:
	 * 
	 * A set of integers 𝑎1,𝑎2,...,𝑎𝑛 can be combined (using integer coefficients) 
	 * to get 1 if and only if their greatest common divisor is 1.
	 * 
	 * So, the array nums is good if and only if:
	 * gcd(nums[0],nums[1],...,nums[n−1])=1
	 * 
	 * Compute the GCD of the entire array
	 * If the GCD is 1 → return true
	 * Otherwise → return false
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int i = 0; i < nums.length; i++) {
			gcd = getGCD(gcd,nums[i]);
			if(gcd==1) {
				return true;
			}
		}
		return false;
    }
	
	private static int getGCD(int gcd, int num) {
		while(num!=0) {
			int temp = num;
			num = gcd%num;
			gcd=temp;
		}
		return gcd;
	}

}
