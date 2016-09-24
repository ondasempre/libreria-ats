package com.ats.beans;

import java.util.*; //sincronizzata/thread safe

/*
 * classe per gestire il carrello
 * aggiungi prodotto
 * rimuovi prodotto
 * calcola totale complessivo
 * calcola totale parziale
 * calcola quantita
 */
public class Carrello {
	private Hashtable<String, String[]> prodotti = new Hashtable<String, String[]>();
	private int articoli;
	
	public Carrello(){
		//azzero il conteggio degli articoli quando viene generato un nuovo carrello
		articoli = 0;
	}
	
	public int numeroArticoli(){
		return articoli;
	}
	
	public void aggiungiLibro(String id, String titolo, String autore, double prezzo){
		String[] record = {titolo, autore, Double.toString(prezzo), "1", id};
		articoli++;
		if(prodotti.containsKey(id)){
			String[] dati = prodotti.get(id);
			int quantita = Integer.parseInt(dati[3]);
			quantita++;
			dati[3] = Integer.toString(quantita);
			prodotti.put(id, dati);
		}else{
			prodotti.put(id, record);
		}
	}
	
	public void rimuoviLibro(String id){
		if(prodotti.containsKey(id)){
			articoli--;
			String[] dati = prodotti.get(id);
			int quantita = Integer.parseInt(dati[3]);
			quantita--;
			if (quantita == 0){
				prodotti.remove(id);
			}else{
				dati[3] = Integer.toString(quantita);
				prodotti.put(id, dati);	
			}
			
		}
	}
	
	public double totaleComplessivo(){
		Enumeration<String[]> enumerazione = prodotti.elements();
		double totale = 0.00;
		String[] dati;
		while(enumerazione.hasMoreElements()){
			dati = enumerazione.nextElement();
			totale += Integer.parseInt(dati[3])*Double.parseDouble(dati[2]);
		}
		return totale;
	}
	
	public double totaleParziale(String id){
		double totale = 0.00;
		String[] dati = prodotti.get(id);
		totale += Integer.parseInt(dati[3])*Double.parseDouble(dati[2]);
		
		return totale;
	}
	
	public Enumeration<String[]> enumerazione(){
		return prodotti.elements();
	}
}