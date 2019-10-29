package model.utils;

import java.io.IOException;

import model.DataSet;
import model.algorithms.Cosine;
import model.algorithms.JaroWinkler;
import model.algorithms.Levenshtein;
import model.algorithms.Trigram;

import java.text.DecimalFormat;

/**
 * Class contains the method for to plot matrix
 * 
 * @author Ranna Raabe
 * @since Oct 29, 2019
 */
public class ConfusionMatrix {

	/**
	 * To print the confusion matrix 
	 * 
	 * @param qnt
	 * @throws IOException
	 */
	public void printMatrix(int qnt) throws IOException {
		Cosine cosine = new Cosine();
		Trigram trigram = new Trigram();
		JaroWinkler jaro = new JaroWinkler();
		Levenshtein levenshtein = new Levenshtein();
		
		DataSet data = new DataSet();
		
		String t1, t2;
		double[][] matrix;
		matrix = new double[qnt][qnt];
		
		for (int i = 0; i < qnt; i++) {
			for (int j = 0; j < qnt; j++) {
				t1 = data.reader(".\\dataset\\output\\pdf"+ (i+1) +".txt");
				t2 = data.reader(".\\dataset\\output\\pdf"+ (j+1) +".txt");
								
				matrix[i][j] = jaro.similarity(t1, t2);
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		for (int i = 0; i < qnt; i++) {
			for (int j = 0; j < qnt; j++) {
				if(i == j)
					System.out.print("------" + "        ");
				else
					System.out.print(df.format(matrix[i][j]) + "%        ");
			}
			System.out.println("");
		}
	}
}
