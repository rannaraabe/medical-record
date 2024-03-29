package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contains method of file reader
 * 
 * @author Ranna Raabe
 * @since Sep 9, 2019
 */
public class DataSet {

	/**
	 * Reading and mining the archive of the texts
	 * 
	 * @param path
	 * @throws IOException
	 */
	public String readerMining(String path) throws IOException {
		BufferedReader br = null;
		String linha = "", text = "";

		ArrayList<String> list = new ArrayList<String>();

		TextMining tm = new TextMining();

		// Reading the text
		try {
			br = new BufferedReader(new FileReader(path));
			int cont = 0;
			while ((linha = br.readLine()) != null) {
				String[] dataset = linha.split("\n");
				String noticia = dataset[dataset.length - 1];
				cont++;

				// Salvo a partir da 12a linha ate encontrar a String "Atendimento"
				if (cont > 13) {
					if (noticia.contains("Atendimento: "))
						break;

					// Mining the text
					text = tm.setMethodsMining(noticia);
//					System.out.println(text);

					// Adding the text mining in list
					if (!text.equals("") && !text.equals(" ") && !text.equals("\n"))
						list.add(text);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// Converting the list in string
		String texto = "";
		for (String palavra : list)
			texto += palavra;

		return texto;
	}

	/**
	 * Reading the archive
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String readerArchive(String path) throws IOException {
		BufferedReader br = null;
		String linha = "", text = "";
		ArrayList<String> list = new ArrayList<String>();
		int cont = 0;

		// Reading the text
		try {
			br = new BufferedReader(new FileReader(path));
			while ((linha = br.readLine()) != null) {
				String[] dataset = linha.split("\n");
				text = dataset[dataset.length - 1] + "\n";
				cont++;

				// Salvo a partir da 12a linha ate encontrar a String "Atendimento"
				if (cont > 13) {
					if (text.contains("Atendimento: "))
						break;

					list.add(text);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

//		System.out.println(text);
		// Converting the list in string
		String texto = "";
		for (String palavra : list)
			texto += palavra;

//		System.out.println(texto);
		return texto;
	}

}
