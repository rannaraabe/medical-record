package model;

import java.util.ArrayList;

/**
 * Class contains the method Trigram metric
 * 
 * @author Ranna Raabe
 * @since Oct 08, 2019
 */
public class Trigram implements CompareStrings {

	/**
	 * Apply Trigram metric: calculate the n-grams a contiguous sequence of n items
	 * from a give text
	 * 
	 * @return the value of similarity 0 <= value <= 1
	 */
	@Override
	public double similarity(String textA, String textB) {
		// Array for to save tri-grams of strings
		ArrayList<String> trigA = new ArrayList<String>();
		ArrayList<String> trigB = new ArrayList<String>();

		// Saving the tri-grams of strings
		for (int i = 0; i < textA.length() - 2; i++) {	// difference of 2 because one word with lenght "x" make x-2 tri-grams 
			if (textA.length() >= 3)
				trigA.add(textA.substring(i, i + 3));
		}

		for (int i = 0; i < textB.length() - 2; i++) {
			if (textB.length() >= 3)
				trigB.add(textB.substring(i, i + 3));
		}

		// Printando pra teste
//		System.out.println(trigA);
//		System.out.println(trigB);

		// Comparing
		int count = 0;
		double calc;
		
		ArrayList<String> menor = trigA.size() < trigB.size() ? trigA : trigB;

		for (int i = 0; i < menor.size(); i++) {
				if (trigA.get(i).equals(trigB.get(i)))
					count++;
				else
					continue;
		}

		// Calculating the number of unique tri-grams
		calc = ((trigA.size() - count) + (trigB.size() - count)) + count;
	
		// Return percentage
		return (count / calc);
	}

}
