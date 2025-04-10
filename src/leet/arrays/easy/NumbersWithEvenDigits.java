package leet.arrays.easy;

public class NumbersWithEvenDigits {
	/**Given an array nums of integers, return how many of them 
	 * contain an even number of digits.
	 *
	 */
	public static void main(String[] args) {
		int[] nums = {12,345,2,6,7896};
		System.out.println(findNumbersSol2(nums));
	}
	
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
        	int numOfDigits = 0;
			while(num!=0) {
				numOfDigits++;
				num/=10;
			}
			if(numOfDigits%2==0)count++;
		}
        return count;
    }
    
    public static int findNumbersSol2(int[] nums) {
        int count = 0;
        for (int num : nums) {
        	if(((int)Math.log10(num)+1)%2==0)count++;
		}
        return count;
    }

}
