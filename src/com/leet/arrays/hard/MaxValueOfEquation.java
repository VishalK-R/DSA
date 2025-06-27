package com.leet.arrays.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxValueOfEquation {

	/**
	 * You are given an array points containing the coordinates of points on a 2D
	 * plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj
	 * for all 1 <= i < j <= points.length. You are also given an integer k.
	 * 
	 * Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj|
	 * <= k and 1 <= i < j <= points.length.
	 * 
	 * It is guaranteed that there exists at least one pair of points that satisfy
	 * the constraint |xi - xj| <= k.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] ar = { { 1, 3 }, { 2, 0 }, { 5, 10 }, { 6, -10 } };
		System.out.println(findMaxValueOfEquationUsingBruteForce(ar, 1));
		System.out.println(findMaxValueOfEquationUsingMaxHeap(ar, 1));
		System.out.println(findMaxValueOfEquation(ar, 1));
	}
	
	public static int findMaxValueOfEquationUsingBruteForce(int[][] points, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= points.length-k; i++) {
			int xi = points[i][0];
			int yi = points[i][1];
			for (int j = i+1; j < points.length && points[j][0]-xi <= k; j++) {
				int xj = points[j][0];
				int yj = points[j][1];
				max = Math.max(max, yi-xi+xj+yj);
			}
		}
		return max;
		
	}
	
	public static int findMaxValueOfEquationUsingMaxHeap(int[][] points, int k) {
		int max = Integer.MIN_VALUE;
		PriorityQueue<int []> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
		for(int [] point: points) {
			int x = point[0];
			int y = point[1];
			while(!maxHeap.isEmpty() && x-maxHeap.peek()[1]>k) {
				maxHeap.poll();
			}
			
			if(!maxHeap.isEmpty()) {
				max = Math.max(max, maxHeap.peek()[0]+x+y);
			}
			
			maxHeap.add(new int[] {y-x,x});
		}
		return max;
	}

	public static int findMaxValueOfEquation(int[][] points, int k) {
		// Initialize max result value
		int max = Integer.MIN_VALUE;
		// Deque to store [y - x, x] pairs
		Deque<int[]> monotonicDeque = new LinkedList<>();
		
		for (int[] point : points) {
			int x = point[0];
			int y = point[1];
			// Remove points from the front if they are out of the valid range (x - xi > k)
			while (!monotonicDeque.isEmpty() && x - monotonicDeque.peek()[1] > k) {
				// Remove oldest point i.e from (front)
				monotonicDeque.poll();
			}
			
			// If there are valid points in the deque, calculate the candidate max value
		    // max = max(max, (yi - xi) + (yj + xj))
			if (!monotonicDeque.isEmpty()) {
				// Best candidate (yi - xi, xi)
				int[] best = monotonicDeque.peek();
				max = Math.max(max, best[0] + x + y);
			}

			// Maintain a decreasing deque of (y - x) values
		    // Remove from the back while current value is better than or equal to the last one
			while (!monotonicDeque.isEmpty() && monotonicDeque.peekLast()[0] < (y - x)) {
				monotonicDeque.pollLast();
			}

			// Add current point's (y - x, x) to the deque
			monotonicDeque.add(new int[] { y - x, x });
		}
		return max;
	}

}
