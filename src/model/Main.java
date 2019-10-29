package model;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		Cosine cosine = new Cosine();
		Trigram trigram = new Trigram();
		JaroWinkler jaro = new JaroWinkler();
		Levenshtein levenshtein = new Levenshtein();
		
		/*ReaderPDF readerPDF = new ReaderPDF();
		try {
			readerPDF.generateTxtFromPDF(".\\dataset\\1256981\\anamnese.pdf", 1);
			readerPDF.generateTxtFromPDF(".\\dataset\\1265206\\abril\\anamnese.pdf", 2);
			readerPDF.generateTxtFromPDF(".\\dataset\\1265206\\marco\\anamnese.pdf", 3);
			readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Abril\\anamnese.pdf", 4);
			readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Fevereiro\\anamnese.pdf", 5);
			readerPDF.generateTxtFromPDF(".\\dataset\\1266303\\Janeiro\\anamnese.pdf", 6);
			readerPDF.generateTxtFromPDF(".\\dataset\\1274547\\abril\\anamnese.pdf", 7);
			readerPDF.generateTxtFromPDF(".\\dataset\\1274547\\fevereiro\\anamnese.pdf", 8);
			readerPDF.generateTxtFromPDF(".\\dataset\\1303825\\anamnese.pdf", 9);
			readerPDF.generateTxtFromPDF(".\\dataset\\1352277\\anamnese.pdf", 10);
			readerPDF.generateTxtFromPDF(".\\dataset\\1359959\\anamnese.pdf", 11);
			readerPDF.generateTxtFromPDF(".\\dataset\\1360577\\anamnese.pdf", 12);
			readerPDF.generateTxtFromPDF(".\\dataset\\1367283\\anamnese.pdf", 13);
			readerPDF.generateTxtFromPDF(".\\dataset\\617241\\anamnese.pdf", 14);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		DataSet data = new DataSet();
		System.out.println("=====================1===================");
		String t1 = data.reader(".\\dataset\\output\\pdf1.txt");
		System.out.println(t1);
		
		System.out.println("====================2====================");
		String t2 = data.reader(".\\dataset\\output\\pdf2.txt");
		System.out.println(t2);
		
		System.out.println("====================3====================");
		String t3 = data.reader(".\\dataset\\output\\pdf3.txt");
		System.out.println(t3);
		
		System.out.println("====================4====================");
		String t4 = data.reader(".\\dataset\\output\\pdf4.txt");
		System.out.println(t4);
		
		System.out.println("====================5====================");
		String t5 = data.reader(".\\dataset\\output\\pdf5.txt");
		System.out.println(t5);
						
		System.out.println("Cosine t1, t2: " + cosine.similarity(t1, t2));
		System.out.println("Cosine t1, t3: " + cosine.similarity(t1, t3));
		System.out.println("Cosine t1, t4: " + cosine.similarity(t1, t4));
		System.out.println("Cosine t1, t5: " + cosine.similarity(t1, t5));
		
		System.out.println("Trigram: " + trigram.similarity(t1, t2));
		System.out.println("Trigram: " + trigram.similarity(t1, t3));
		System.out.println("Trigram: " + trigram.similarity(t1, t4));
		System.out.println("Trigram: " + trigram.similarity(t1, t5));
		
		System.out.println("JaroWinkler: " + jaro.similarity(t1, t2));
		System.out.println("Levenshtein: " + levenshtein.similarity(t1, t3));
			
	}

}
