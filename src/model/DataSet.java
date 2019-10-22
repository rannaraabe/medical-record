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
	 * Read the archive of the texts
	 * 
	 * @param path
	 */
	public String reader(String path) {
		BufferedReader br = null;
		String linha = "", text = "";
		
		ArrayList<String> list = new ArrayList<String>();
		
		TextMining tm = new TextMining();

		// Reading the text
		try {
			br = new BufferedReader(new FileReader(path));

			while ((linha = br.readLine()) != null) {
				String[] dataset = linha.split("\n");
				String noticia = dataset[dataset.length - 1];
				
				// Mining the text
				text = tm.setMethodsMining(noticia);
				
				// Adding the text mining in list
				if(!text.equals("") &&
						!text.equals(" ") &&
						!text.equals("\n"))
					list.add(text);
				
				//System.out.println(text + "\n");
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
		for(String palavra : list)
			texto += palavra;
				
		return texto;
	}
	
}
