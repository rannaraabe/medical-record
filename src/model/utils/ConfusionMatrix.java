package model.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import model.DataSet;
import model.algorithms.Cosine;
import model.algorithms.JaroWinkler;
import model.algorithms.Levenshtein;
import model.algorithms.Trigram;

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
	public String printMatrix(int qnt, List<File> files, String met) throws IOException {
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
				
				t1 = data.readerMining(files.get(i).getAbsolutePath());
				t2 = data.readerMining(files.get(j).getAbsolutePath());
			
				if(met == "cosine")
					matrix[i][j] = cosine.similarity(t1, t2);
				else if(met == "trigram")
					matrix[i][j] = trigram.similarity(t1, t2);
				else if(met == "jaro")
					matrix[i][j] = jaro.similarity(t1, t2);
				else if(met == "levenshtein")
					matrix[i][j] = levenshtein.similarity(t1, t2);
			}
		}
		
		String matriz = "";
		DecimalFormat df = new DecimalFormat("0.00");

		for (int i = 0; i < qnt; i++) {
			for (int j = 0; j < qnt; j++) {
				if (i == j)
					matriz += "----------" + "        ";
				else {
					if(met == "levenshtein")
						matriz += df.format(matrix[i][j]) + "         ";
					else
						matriz += df.format(matrix[i][j]) + "%        ";
				}
					
			}
			matriz += "\n";
		}
		
		return matriz;
	}
}
