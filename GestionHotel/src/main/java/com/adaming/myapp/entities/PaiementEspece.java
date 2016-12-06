package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/* PaiementEspece
*  Version: 1.0.0
*  Date: 05-12-2016
*  Author: Brice Touchard
*/	

@Entity
@DiscriminatorValue("Espece")
public class PaiementEspece extends Paiement {

	//=========================
	// Attributes
	//=========================
	private String devise;
		
   
	//=========================
	// Constructor
	//=========================
 
	public PaiementEspece() {
		super();
	}

	public PaiementEspece(double coutTotal, Date date) {
		super(coutTotal, date);
	}


	public PaiementEspece(double coutTotal, Date date, String devise) {
		super(coutTotal, date);
		this.devise = devise;
	}

	//=========================
	// Getter / Setter
	//=========================
		
	public String getDevise() {
		return devise;
	}
	
	public void setDevise(String devise) {
		this.devise = devise;
	} 

}

