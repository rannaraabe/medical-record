package model.algorithms;

/**
 * Class contains the method Cosine metric
 * 
 * @author Ranna Raabe
 * @since Sep 25, 2019
 */
public class Cosine implements CompareStrings {

	/**
	 * Apply Cosine metric: calculate the cosine of the angular project for two
	 * vectors in the space multidimensional
	 * 
	 * @return of value of similarity 0 <= value <= 1
	 */
	@Override
	public double similarity(String textA, String textB) {
		double sumAB = 0, sumA = 0, sumB = 0;

		// Summation AiBi
		for (int i = 0; i < Integer.min(textA.length(), textB.length()); i++)
			sumAB += textA.charAt(i) * textB.charAt(i);

		// Summation (Ai)^2
		for (int i = 0; i < textA.length(); i++)
			sumA += textA.charAt(i) * textA.charAt(i);

		// Summation (Bi)^2
		for (int j = 0; j < textB.length(); j++)
			sumB += textB.charAt(j) * textB.charAt(j);

		// Multiplication of denominator
		double multD = Math.sqrt(sumA) * Math.sqrt(sumB);

		return (sumAB / multD)*100;
	}
}
