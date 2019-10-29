package model.algorithms;

/**
 * Class contains the method Jaro-Winkler metric
 * 
 * @author Ranna Raabe
 * @since Oct 08, 2019
 */
public class JaroWinkler implements CompareStrings {

	/**
	 * Apply Jaro-Winkler metric:
	 * 
	 * @return percentage of value of similarity
	 */
	@Override
	public double similarity(String textA, String textB) {
		String menor = textA.length() < textB.length() ? textA : textB;
		double dj = 0, jw = 0;
		int[] contagem = new int[300];
		
		for(int i = 0; i < textA.length(); i++) {
			contagem[(int)textA.charAt(i)]++;
		}
		
		// Calculating equal characters
		int m = 0;
		for(int i = 0; i < textB.length(); i++) {
			if(contagem[(int)textB.charAt(i)] > 0) {
				m++;
				contagem[(int)textB.charAt(i)]--;
			}
		}

		// Calculating the half of number of transpositions
		int t = 0;
		for (int i = 0; i < menor.length(); i++) {
			if ((textA.charAt(i) != (textB.charAt(i))))
				t++;
			else
				continue;
		}
		t = t / 2;

		// Calculating number dj
		dj = (1 / 3.0) * (((double)m / textA.length()) + ((double)m / textB.length()) + (((double)m - t) / m));

		int l = 0;
		while(l < 4 && l<menor.length() && textA.charAt(l) == textB.charAt(l))
			l++;		
		
		// Calculating number jw
		jw = dj + (l * 0.1 * (1 - dj));

		return jw*100;
	}

}
