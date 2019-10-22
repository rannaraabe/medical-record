package model;

public class Main {
	public static void main(String[] args) {

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
		String result = data.reader(".\\dataset\\output\\pdf1.txt");
		String result2 = data.reader(".\\dataset\\output\\pdf7.txt");
		
		System.out.println(result);
		System.out.println(result2);

		
		System.out.println("Cosine: " + cosine.similarity(result, result2));
		System.out.println("Trigram: " + trigram.similarity(result, result2));
		System.out.println("JaroWinkler: " + jaro.similarity(result, result2));
		System.out.println("Levenshtein: " + levenshtein.similarity(result, result2));
			
	}

}
