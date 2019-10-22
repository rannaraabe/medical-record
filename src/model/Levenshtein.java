package model;

/**
 * Class contains the method Levenshtein metric
 * 
 * @author Ranna Raabe
 * @since Sep 26, 2019
 *
 */
public class Levenshtein implements CompareStrings {

	/**
	 * Apply Levenshtein distance: calculate the minimum of operations for to turn one
	 * String in other
	 * 
	 * @return value of numbers of operations
	 */
	@Override
	public double similarity(String textA, String textB) {

		// Calculate the length of strings
		int lenA = textA.length() + 1;
		int lenB = textB.length() + 1;

		int[] cost = new int[lenA];
		int[] newcost = new int[lenA];

		for (int i = 0; i < lenA; i++)
			cost[i] = i;

		// Calculate the cost for the string B
		for (int j = 1; j < lenB; j++) {
			newcost[0] = j;

			for (int i = 1; i < lenA; i++) {
				int match = (textA.charAt(i - 1) == textB.charAt(j - 1)) ? 0 : 1;

				// Cost for replace, insert and delete
				int cost_replace = cost[i - 1] + match;
				int cost_insert = cost[i] + 1;
				int cost_delete = newcost[i - 1] + 1;

				// Minimum into costs
				newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
			}
			
			// Cost turn in newcost and newcost turn in cost
			int[] swap = cost;
			cost = newcost;
			newcost = swap;
		}

		return cost[lenA - 1];
	}

}
