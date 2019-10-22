package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class contains method to generate the key SHA-01
 * 
 * @author Ranna Raabe
 * @since Aug 14, 2019
 */
public class Sha {

	/**
	 * Generate a key SHA-01 with the text
	 * 
	 * @throws NoSuchAlgorithmException
	 * @return key SHA-01
	 */
	public String keySHA(String texto) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] keyInBytes = md.digest(texto.getBytes(StandardCharsets.UTF_8));

		// Bytes to hex
		StringBuilder sb = new StringBuilder();

		for (byte b : keyInBytes)
			sb.append(String.format("%02x", b));

		return sb.toString();
	}
}
