package model;

import java.util.ArrayList;

/**
 * Class contains attributes and methods of medical record
 * 
 * @author Ranna Raabe
 * @since Sep 23, 2019
 */
public class MedicalRecord {
	private ArrayList<String> medicialOriginal;
	private ArrayList<String> medicalMined;
	private String url;
	private String data;
	TextMining tm = new TextMining();

	public MedicalRecord(ArrayList<String> medicialOriginal, String url, String data) {
		this.medicialOriginal = medicialOriginal;

		medicalMined = new ArrayList<String>();
		for (String no : medicialOriginal)
			medicalMined.add(tm.setMethodsMining(no));

		this.url = url;
		this.data = data;
	}

	public ArrayList<String> getNoticia() {
		return medicialOriginal;
	}

	public void setNoticia(ArrayList<String> medicialOriginal) {
		this.medicialOriginal = medicialOriginal;
	}

	public ArrayList<String> getMedicalMined() {
		return medicalMined;
	}

	public void setMedicalMined(ArrayList<String> medicalMined) {
		this.medicalMined = medicalMined;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
