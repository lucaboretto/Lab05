package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import connectDB.DizionarioDAO;

public class Model {
	
	DizionarioDAO dizioarioDao = new DizionarioDAO();
	List<Parola> risultato = new ArrayList<Parola>();
	
	public List<Parola> anagrammi(String parola){
		int livello = 0;
		String parziale = "";
		
		cercaAnagrammi(parola, parola, livello, parziale);
		return risultato;
	}
	
	private void cercaAnagrammi(String parola, String lettere, int livello, String parziale) {
		
		if(parziale.length() == parola.length()) {
			Parola p;
			if(esisteParola(parziale))
				p = new Parola(parziale, true);
			else
				p = new Parola(parziale, false);
			risultato.add(p);
		}
		else {
			for(int i=0; i<lettere.length(); i++) {
				String nuovaParziale = parziale + lettere.charAt(i);
				String nuovaLettere = lettere.substring(0, i) + lettere.substring(i+1);
				cercaAnagrammi(parola, nuovaLettere, livello+1, nuovaParziale);
		
			}
		}
		
	}
	
	private boolean esisteParola(String parola) {
		//controlla il DataBase
		 return this.dizioarioDao.esiste(parola);
	}
	
	
	public void removeRisultato() {
		this.risultato.remove(risultato);
	}
}
