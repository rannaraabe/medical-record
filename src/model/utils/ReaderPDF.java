package model.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Class contains method of generate txt from PDF
 * 
 * @author Eugen (https://github.com/eugenp/tutorials/tree/master/pdf)
 */
public class ReaderPDF {
	/**
	 * Convert the archive PDF into txt
	 * 
	 * @param filename path of archive
	 * @param cod code for name of archive txt
	 */
	public void generateTxtFromPDF(String filename, int cod) throws IOException {
		// Loading of PDF
		File f = new File(filename);
		String parsedText;
		PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
		parser.parse();

		// Extraction of text
		COSDocument cosDoc = parser.getDocument();

		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);

		parsedText = pdfStripper.getText(pdDoc);

		if (cosDoc != null)
			cosDoc.close();
		if (pdDoc != null)
			pdDoc.close();

		// Final making of archive .txt
		PrintWriter pw = new PrintWriter(".\\dataset\\output\\pdf"+ cod +".txt");
		pw.print(parsedText);
		pw.close();
	}
	
}
