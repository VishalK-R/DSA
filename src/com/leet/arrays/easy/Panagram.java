package com.leet.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class Panagram {
	
	/**
	 * A pangram is a sentence where every letter of the English alphabet appears at least once.

	 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
	 * 
	 * Example 1:
	 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
	 * Output: true
	 * Explanation: sentence contains at least one of every letter of the English alphabet.
	 * 
	 * Example 2:
	 * Input: sentence = "leetcode"
     * Output: false
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		String sentence = "onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab";
		System.out.println(checkPanagram(sentence));
		System.out.println(checkPanagramWithoutSet(sentence));

	}

	private static boolean checkPanagram(String sentence) {
		char [] sentenceChars = sentence.toCharArray();
		Set <Character> sentenceCharsWithoutDuplicates = new HashSet<>();
		for (int i = 0; i < sentenceChars.length; i++) {
			sentenceCharsWithoutDuplicates.add(sentenceChars[i]);
		}
		System.out.println(sentenceCharsWithoutDuplicates.toString());
		return sentenceCharsWithoutDuplicates.size()==26;
	}
	
	private static boolean checkPanagramWithoutSet(String sentence) {
		if(sentence.length()<26) return false;
		for (int i = 'a'; i <= 'z'; i++) {
			if(sentence.indexOf(i)==-1) {
				return false;
			}
		}
		return true;
	}

}
