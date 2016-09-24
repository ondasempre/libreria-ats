package com.ats.beans;

public class OrdineArticolo {
	private long id_ordine;
	private int id_articolo;
	private int quantita;
	
	public long getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}
	public int getId_articolo() {
		return id_articolo;
	}
	public void setId_articolo(int id_articolo) {
		this.id_articolo = id_articolo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}