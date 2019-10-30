package model.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class contains the method for to create new file
 * 
 * @author Ranna Raabe
 * @since Oct 30, 2019
 */
public class NewArchive {

	/**
	 * Creating the new file with the results
	 * 
	 * @param conteudo
	 * @throws FileNotFoundException 
	 */
	public void generateFile(String conteudo, int cod) throws FileNotFoundException {	
		PrintWriter pw = new PrintWriter(".\\dataset\\resultados\\resultadoAnamnese" + cod + ".txt");
		pw.print(conteudo);
		pw.close();
	}
}
