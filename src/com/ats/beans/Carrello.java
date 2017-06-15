package com.ats.beans;
//sincronizzata hashtable
import java.util.*;


public class Carrello {
	private Hashtable<String, String[]>prodotto=  new Hashtable<String,String[]>();
	
	private int articoli;
	public Carrello()
	{
		articoli=0;
	}
	public int numeroArticoli()
	{
		return articoli;
	}
	//non lo passo da bean perche i dati del libro non lo popolo dal form
	public void aggiungiLibroAlCarrello(String id, String titolo,String autore,double prezzo)
	{
		String[]record={titolo, autore, Double.toString(prezzo),"1", id};//1 è la quantita
		articoli++;
		if(prodotto.containsKey(id))
		{
			String[] dati= prodotto.get(id);
			int quantita=Integer.parseInt(dati[3]);
			quantita++;
			dati[3]=Integer.toString(quantita);
			prodotto.put(id, dati);
		}
		else
		{
			prodotto.put(id, record);
		}
	}
	public void rimuoviLibro(String id)
	{
		if(prodotto.containsKey(id))
		{
			articoli--;
			String[] dati=prodotto.get(id);
			if(Integer.parseInt(dati[3])==1)
			{
				prodotto.remove(id);
			}
			else
			{
				int quantita=Integer.parseInt(dati[3]);
				quantita--;
				dati[3]=Integer.toString(quantita);
				prodotto.put(id, dati);
			}
		}
	}
	
	public double totaleComplessivo()
	{
		Enumeration<String[]> enumerazione=prodotto.elements();
		String[] dati;
		double totale=0.00;
		while(enumerazione.hasMoreElements())
		{
			dati=enumerazione.nextElement();
			totale+=Integer.parseInt(dati[3])*Double.parseDouble(dati[2]);
		}
		return totale;
	}
	public double totaleParziale(String id)
	{
		
		String[] dati=prodotto.get(id);
		double totale=0.00;
		totale+=Integer.parseInt(dati[3])*Double.parseDouble(dati[2]);
		return totale;
	}
	public Enumeration<String[]> enumerazione()
	{
		return prodotto.elements();
	}

}
