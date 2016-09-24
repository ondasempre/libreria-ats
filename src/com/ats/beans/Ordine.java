package com.ats.beans;

import java.util.Date;

public class Ordine {
	private long id_ordine;	//questo id viene generato dalla sequenza
							//la sequenza ritorna un dato long
	private double totale;
	private Date data;
	private String username;
	
	public long getId_ordine() {
		return id_ordine;
	}
	public void setId_ordine(long id_ordine) {
		this.id_ordine = id_ordine;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}