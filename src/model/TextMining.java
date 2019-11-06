package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class contains methods of text mining
 * 
 * @author Ranna Raabe
 * @since Aug 13, 2019
 */
public class TextMining {

	private static int MIN_TEXT = 4;

	/**
	 * Remove all small words of text. Character min=3
	 * 
	 * @param text
	 * @return text without small words
	 */
	public String removeSmallWords(String text) {
		String texto[] = text.split(" ");
		text = "";

		// Redoing text only with words under 3 characters
		for (String word : texto) {
			if (word.length() >= MIN_TEXT) {
				text += word;
				text += " ";
			}
		}

		return text;
	}

	/**
	 * Remove all upper cases of words
	 * 
	 * @param text
	 * @return text without upper cases words
	 */
	public String removeUpperCases(String text) {
		text = text.toLowerCase();

		return text;
	}

	/**
	 * Remove all accents of words
	 * 
	 * @param text
	 * @return text without accents words
	 */
	public String removeAccent(String text) {
		text = text.replaceAll("[�����]", "a");
		text = text.replaceAll("[����]", "e");
		text = text.replaceAll("[����]", "i");
		text = text.replaceAll("[�����]", "o");
		text = text.replaceAll("[����]", "u");

		return text;
	}

	/**
	 * Remove all special characters of phrase
	 * 
	 * @param text
	 * @return text without special characters
	 */
	public String removeSpecialCharacters(String text) {
		//text = text.replaceAll("[.,;��:?!/\"#%@&$*()-]1234567890", "");
		text = text.replaceAll("[^\\p{Alpha} ]", "");

		return text;
	}

	/**
	 * Remove all duplicate words
	 * 
	 * @param text
	 * @return text without duplicate words
	 */
	public String removeDuplicateWords(String text) {
		String texto[] = text.split(" ");
		ArrayList<String> newText = new ArrayList<String>();

		// Searching to words not duplicate for add
		for (String word : texto) {
			if (newText.contains(word) == false)
				newText.add(word);
		}

		// Redoing text
		text = "";
		for (String word : newText) {
			text += word;
			text += " ";
		}

		return text;
	}

	/**
	 * Ordering the text in alphabetical order
	 * 
	 * @param text
	 * @return text in alphabetical order
	 */
	public String ordingWords(String text) {
		String texto[] = text.split(" ");

		// Using method sort to sort
		Arrays.sort(texto);

		// Redoing text
		text = "";
		for (String word : texto) {
			text += word;
			text += " ";
		}

		return text;
	}
	
	/**
	 * Mining the text with all methods in TextMining class
	 * 
	 * @param text
	 * @return text mining
	 */
	public String setMethodsMining(String text) {		
		text = removeSmallWords(text);
		text = removeUpperCases(text);
		text = removeAccent(text);
		text = removeSpecialCharacters(text);
		text = removeDuplicateWords(text);
		text = ordingWords(text);
		
		return text;
	}

}
