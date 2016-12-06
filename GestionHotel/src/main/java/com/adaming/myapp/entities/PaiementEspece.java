package com.adaming.myapp.entities;

import java.util.Date;

/* PaiementEspece
*  Version: 1.0.0
*  Date: 05-12-2016
*  Author: Brice Touchard
*/	
public class PaiementEspece extends Paiement {

	//=========================
	// Attributes
	//=========================
	private int devise;
		
   
	//=========================
	// Constructor
	//=========================
 
	public PaiementEspece() {
		super();
	}

	public PaiementEspece(double coutTotal, Date date) {
		super(coutTotal, date);
	}


	public PaiementEspece(double coutTotal, Date date, int devise) {
		super(coutTotal, date);
		this.devise = devise;
	}

	//=========================
	// Getter / Setter
	//=========================
		
	public int getDevise() {
		return devise;
	}
	
	public void setDevise(int devise) {
		this.devise = devise;
	} 

}

