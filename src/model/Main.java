package model;

import java.io.IOException;

import model.algorithms.Cosine;
import model.algorithms.JaroWinkler;
import model.algorithms.Levenshtein;
import model.algorithms.Trigram;

public class Main {
	public static void main(String[] args) throws IOException {

		/*
		 * ReaderPDF readerPDF = new ReaderPDF(); try {
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1256981\\anamnese.pdf", 1);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1265206\\abril\\anamnese.pdf", 2);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1265206\\marco\\anamnese.pdf", 3);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Abril\\anamnese.pdf", 4);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Fevereiro\\anamnese.pdf",
		 * 5);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Janeiro\\anamnese.pdf",
		 * 6); readerPDF.generateTxtFromPDF(".\\dataset\\1274547\\abril\\anamnese.pdf",
		 * 7);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1274547\\fevereiro\\anamnese.pdf",
		 * 8); readerPDF.generateTxtFromPDF(".\\dataset\\1303825\\anamnese.pdf", 9);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1352277\\anamnese.pdf", 10);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1359959\\anamnese.pdf", 11);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1360577\\anamnese.pdf", 12);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\1367283\\anamnese.pdf", 13);
		 * readerPDF.generateTxtFromPDF(".\\dataset\\617241\\anamnese.pdf", 14); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */

		Cosine c = new Cosine();
		Trigram t = new Trigram();
		Levenshtein l = new Levenshtein();
		JaroWinkler j = new JaroWinkler();
		
		System.out.println("cosine: " + c.similarity(
				"acianotico anictorico ano consciente egh eupneico exame g1p0 ig35sem6d liquido normocorado normohidratado orientado perda",
				"36s4d ano consciente egb exame g1p0a0 liquido orientado paciente perda refere vigil"));
		
		System.out.println("trigram: " + t.similarity(
				"acianotico anictorico ano consciente egh eupneico exame g1p0 ig35sem6d liquido normocorado normohidratado orientado perda",
				"36s4d ano consciente egb exame g1p0a0 liquido orientado paciente perda refere vigil"));
		
		System.out.println("levenshtein: " + l.similarity(
				"acianotico anictorico ano consciente egh eupneico exame g1p0 ig35sem6d liquido normocorado normohidratado orientado perda",
				"36s4d ano consciente egb exame g1p0a0 liquido orientado paciente perda refere vigil"));
		
		System.out.println("jaro winkler: " + j.similarity(
				"acianotico anictorico ano consciente egh eupneico exame g1p0 ig35sem6d liquido normocorado normohidratado orientado perda",
				"36s4d ano consciente egb exame g1p0a0 liquido orientado paciente perda refere vigil"));
	}

}
