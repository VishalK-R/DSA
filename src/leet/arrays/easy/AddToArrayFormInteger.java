package leet.arrays.easy;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormInteger {
	/**The array-form of an integer num is an array representing its 
	 * digits in left to right order.
	 * 
	 * For example, for num = 1321, the array form is [1,3,2,1].
	 * 
	 * Given num, the array-form of an integer, and an integer k, 
	 * return the array-form of the integer num + k.
	 * 
	 */
	public static void main(String[] args) {
		int [] num = {9,9,9,9,9,9,9,9,9,9};
		int k = 1;
		addToArrayForm(num,k).stream().forEach(System.out::println);
	}
	
	public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> addedToArrayForm = new LinkedList<>();
        int carryOver = 0;
        for(int i = num.length-1; i>=0; i--) {
        	int numberToBeAdded = num[i]+(k%10)+carryOver;
        	carryOver = numberToBeAdded/10;
        	numberToBeAdded%=10;
        	k/=10;
        	addedToArrayForm.addFirst(numberToBeAdded);
        }
        while(k!=0) {
        	int numberToBeAdded = (k%10)+carryOver;
        	carryOver = numberToBeAdded/10;
        	numberToBeAdded%=10;
        	k/=10;
        	addedToArrayForm.addFirst(numberToBeAdded);
        }
        if(carryOver!=0) {
        	addedToArrayForm.addFirst(carryOver);
        }
        return addedToArrayForm;
    }

}
