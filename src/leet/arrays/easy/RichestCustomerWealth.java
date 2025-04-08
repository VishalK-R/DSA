package leet.arrays.easy;

public class RichestCustomerWealth {
	/**You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ 
	 * customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
	 * 
	 * A customer's wealth is the amount of money they have in all their bank accounts. The richest 
	 * customer is the customer that has the maximum wealth.
	 * 
	 * Constraints:
	 * m == accounts.length
	 * n == accounts[i].length
	 * 1 <= m, n <= 50
	 * 1 <= accounts[i][j] <= 100
	 * 
	 */



	public static void main(String[] args) {
		int [][] nums = {{2,8,7},{7,1,3},{1,9,5}};
		System.out.println(maximumWealth(nums));
	}

	private static int maximumWealth(int[][] nums) {
		int max = 0; //since in constraints it says the value in bank account is always greater than or equal to 1
		for(int m=0;m<nums.length;m++) {
			int sum = 0;
			for(int n=0;n<nums[m].length;n++) {
				sum+=nums[m][n];
			}
			if(sum>max) {
				max=sum;
			}
		}
		return max;
	}

}
