package it.polito.tdp.anagrammi.model;

public class Parola {

	String parola;
	boolean esiste;

	public Parola(String parola, boolean esiste) {
		super();
		this.parola = parola;
		this.esiste = esiste;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isEsiste() {
		return esiste;
	}

	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	} 
	
	
	
}
