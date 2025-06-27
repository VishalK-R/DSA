package com.leet.arrays.easy;

public class MaxPopulationYear {

	/**You are given a 2D integer array logs where each 
	 * logs[i] = [birthi, deathi] indicates the birth and death years 
	 * of the ith person.
	 * 
	 * The population of some year x is the number of people alive 
	 * during that year. The ith person is counted in year x's 
	 * population if x is in the inclusive range [birthi, deathi - 1]. 
	 * Note that the person is not counted in the year that they die.
	 * 
	 * Return the earliest year with the maximum population.
	 */
	public static void main(String[] args) {
		int [][] logs = {{1950,1961},{1960,1971},{1970,1981}};
		System.out.println(maximumPopulation(logs));

	}
	
	public static int maximumPopulation(int[][] logs) {
        int [] countPerYear = new int[101];
        for (int i = 0; i < logs.length; i++) {
			int j =logs[i][0];
			int k =logs[i][1];
			while(j<k) {
				countPerYear[j-1950]++;
				j++;
			}
		}
        
        int maxPopulation = 0;
        int year = 1950;
        for (int i = 0; i < countPerYear.length; i++) {
			if(countPerYear[i]>maxPopulation) {
				maxPopulation=countPerYear[i];
				year = i+1950;
			}
		}
        return year;
    }

}
