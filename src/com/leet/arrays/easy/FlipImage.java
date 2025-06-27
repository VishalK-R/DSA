package com.leet.arrays.easy;

import java.util.Arrays;

public class FlipImage {
	/**Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

	* To flip an image horizontally means that each row of the image is reversed.
	* For example, flipping [1,1,0] horizontally results in [0,1,1].
	* To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
	* For example, inverting [0,1,1] results in [1,0,0]
	**/
	public static void main(String[] args) {
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		Arrays.stream(flipAndInvertImage(image)).map(Arrays::toString).forEach(System.out::println);

	}
	
	public static int[][] flipAndInvertImage(int[][] image) {
        int [][] flippedIvertedImage = new int[image.length][];
        for(int row = 0; row < image.length; row++) {
        	int size = image[row].length;
        	int[] flippedAr = new int[size];
        	for(int col = 0; col<size; col++) {
        		//use xor to flip the number
        		flippedAr[col]=image[row][size-col-1]^1;
        	}
        	flippedIvertedImage[row] = flippedAr;
        }
//        for(int row = 0; row < flippedIvertedImage.length; row++) {
//        	for(int col = 0; col<flippedIvertedImage[row].length; col++) {
//        		if(flippedIvertedImage[row][col]==0) {
//        			flippedIvertedImage[row][col]=1;
//        		}else {
//        			flippedIvertedImage[row][col]=0;
//        		}
//        	}
//        }
        return flippedIvertedImage;
    }

}
