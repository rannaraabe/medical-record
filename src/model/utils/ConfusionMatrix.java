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
	public String printMatrix(int qnt, String met, List<File> nomeArquivos) throws IOException {		
		String[][] matrix;
		matrix = new String[qnt][qnt];
		String matriz = "";
		
		matrix = algoritmoSimilaridade(met, matrix, qnt, nomeArquivos);

		for (int i = 0; i < qnt; i++) {
			for (int j = 0; j < qnt; j++) {
				if (i >= 1 && j >= 1 && i == j)
					matriz += "\t\t\t\t|\t";
				else
					matriz += matrix[i][j];

			}
			matriz += "\n";
		}

		return matriz;
	}

	public String[][] algoritmoSimilaridade(String met, String[][] matrix, int qnt, List<File> nomeArquivos) throws IOException {
		Cosine cosine = new Cosine();
		Trigram trigram = new Trigram();
		JaroWinkler jaro = new JaroWinkler();
		Levenshtein levenshtein = new Levenshtein();

		DataSet data = new DataSet();

		String t1, t2;

		// Colocando os nomes dos arquivos
		for (int i = 0; i < qnt; i++) {
			matrix[0][i] = nomeArquivos.get(i).getName() + "\t|\t";
		}

		for (int i = 1; i < qnt; i++) {
			matrix[i][0] = nomeArquivos.get(i).getName() + "\t|\t";
		}

		DecimalFormat df = new DecimalFormat("0.00");
		// Fazendo a similaridade de cada arquivo com cada arquivo
		for (int i = 1; i < qnt; i++) {
			for (int j = 1; j < qnt; j++) {

				t1 = data.readerMining(".\\dataset\\output\\pdf_anamnese_teste" + i + ".txt");
				t2 = data.readerMining(".\\dataset\\output\\pdf_anamnese_teste" + j + ".txt");

				if (met == "cosine")
					matrix[i][j] = "\t" + df.format(cosine.similarity(t1, t2)) + "%\t\t|\t";
				else if (met == "trigram")
					matrix[i][j] = "\t" + df.format(trigram.similarity(t1, t2)) + "%\t\t|\t";
				else if (met == "jaro")
					matrix[i][j] = "\t" + df.format(jaro.similarity(t1, t2)) + "%\t\t|\t";
				else if (met == "levenshtein")
					matrix[i][j] = "\t" + df.format(levenshtein.similarity(t1, t2)) + " \t\t|\t";
			}
		}
		return matrix;
	}

	/**
	 * Return the value of similarity
	 * 
	 * @throws IOException
	 */
	public double resultadoMatrix(List<File> files, String met) throws IOException {
		Cosine cosine = new Cosine();
		Trigram trigram = new Trigram();
		JaroWinkler jaro = new JaroWinkler();
		Levenshtein levenshtein = new Levenshtein();

		DataSet data = new DataSet();

		ReaderPDF rPDF = new ReaderPDF();
		rPDF.generateTxtFromPDF(files.get(0).getAbsolutePath(), "AA");
		rPDF.generateTxtFromPDF(files.get(1).getAbsolutePath(), "BB");

		String t1, t2;
		double value = 0;

		t1 = data.readerMining(".\\dataset\\output\\pdf_anamneseAA.txt");
		t2 = data.readerMining(".\\dataset\\output\\pdf_anamneseBB.txt");

//		System.out.println(t1 + "\n\n");
//		System.out.println(t2 + "\n\n");

		if (met == "cosine")
			value = cosine.similarity(t1, t2);
		else if (met == "trigram")
			value = trigram.similarity(t1, t2);
		else if (met == "jaro")
			value = jaro.similarity(t1, t2);
		else if (met == "levenshtein")
			value = levenshtein.similarity(t1, t2);

		return value;
	}
}
