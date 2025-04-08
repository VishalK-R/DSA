package leet.arrays.easy;

import java.util.stream.Collectors;
import java.util.*;

public class CountItemsInArrayMatchingRule {
	private static Map<String,Integer> ruleKeyIndexMap;
	static {
		ruleKeyIndexMap = new HashMap<>();
		ruleKeyIndexMap.put("type", 0);
		ruleKeyIndexMap.put("color", 1);
		ruleKeyIndexMap.put("name", 2);
	}
	
	{
		System.out.println("Inside Instance block");
	}
	/*You are given an array items, where each items{i} = {typei, colori, namei} describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
	 * The ith item is said to match the rule if one of the following is true:
	 * ruleKey == "type" and ruleValue == typei.
	 * ruleKey == "color" and ruleValue == colori.
	 * ruleKey == "name" and ruleValue == namei.

	 * Return the number of items that match the given rule.

	 */

	public static void main(String[] args) {
		String[][] items = {{"phone","blue","pixel"},{"computer","silver","lenovo"},{"phone","gold","iphone"}};
		List<List<String>> itemsList = Arrays.stream(items).map(Arrays::asList).collect(Collectors.toList());
		String ruleKey = "color", ruleValue = "silver";
		System.out.println(countMatches(itemsList, ruleKey, ruleValue));
	}
	
	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int index = ruleKeyIndexMap.get(ruleKey), count = 0;
		for (Iterator<List<String>> iterator = items.iterator(); iterator.hasNext();) {
			List<String> list = (List<String>) iterator.next();
			if(list.get(index).equals(ruleValue))count++;
		}
		return count;
    }

}
