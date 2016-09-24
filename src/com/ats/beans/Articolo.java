package com.ats.beans;

public class Articolo 
{
	private int id_articolo;
	private String titolo;
	private String autore;
	private double prezzo;
	
	public int getId_articolo() 
	{
		return id_articolo;
	}
	
	public void setId_articolo(int id_articolo) 
	{
		this.id_articolo = id_articolo;
	}
	
	public String getTitolo() 
	{
		return titolo;
	}
	
	public void setTitolo(String titolo) 
	{
		this.titolo = titolo;
	}
	
	public String getAutore() 
	{
		return autore;
	}
	
	public void setAutore(String autore) 
	{
		this.autore = autore;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) 
	{
		this.prezzo = prezzo;
	}
}