package com.zsgs.thirukuralapplication.dto;

import org.json.simple.JSONObject;

public class Thirukural {
	private long number;
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getTamilexplanation() {
		return tamilexplanation;
	}

	public void setTamilexplanation(String tamilexplanation) {
		this.tamilexplanation = tamilexplanation;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getEnglishTranslation() {
		return englishTranslation;
	}

	public void setEnglishTranslation(String englishTranslation) {
		this.englishTranslation = englishTranslation;
	}

	private String line1;
	private String line2;
	private String tamilexplanation;
	private String translation;
	private String englishTranslation;
	
	public Thirukural (JSONObject jsonObject, String string){
	   this.number = (long)jsonObject.get("Number");
	   this.line1 = (String)jsonObject.get("Line1");
	   this.line2=(String)jsonObject.get("Line2");
	   this.tamilexplanation = (String)jsonObject.get(string);
	   this.translation = (String)jsonObject.get("Translation");
	   this.englishTranslation = (String)jsonObject.get("explanation");
	}
	

}
