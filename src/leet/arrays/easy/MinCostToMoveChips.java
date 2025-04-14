package leet.arrays.easy;

public class MinCostToMoveChips {

	
	/**We have n chips, where the position of the ith chip is position[i].
	 * 
	 * We need to move all the chips to the same position. In one step, we can change 
	 * the position of the ith chip from position[i] to:
	 * 
	 * position[i] + 2 or position[i] - 2 with cost = 0.
	 * position[i] + 1 or position[i] - 1 with cost = 1.
	 * 
	 */
	public static void main(String[] args) {
		int[] position = {1,2,3};
		System.out.println(minCostToMoveChips(position));

	}
	
	public static int minCostToMoveChips(int[] position) {
		int [] oddEvenCount = returnOddEvenCOunt(position);
		int oddCount = oddEvenCount[0];
		int evenCount = oddEvenCount[1];
		if(oddCount>evenCount) {
			return evenCount;
		}else {
			return oddCount;
		}
    }

	private static int[] returnOddEvenCOunt(int[] position) {
		int[] oddEvenCount = new int[2];
		for (int i = 0; i < position.length; i++) {
			if(position[i]%2==1) {
				++oddEvenCount[0];
			}else {
				++oddEvenCount[1];
			}
		}
		return oddEvenCount;
	}

}
