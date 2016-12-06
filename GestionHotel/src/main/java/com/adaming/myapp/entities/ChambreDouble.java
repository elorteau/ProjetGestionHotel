/* Chambre double
 *Version: 1.0.0
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class ChambreDouble extends Chambre{
	
	//=============
	//attributes
	//=============
	private Double prix;
	
	//=============
	//constructors
	//=============
	public ChambreDouble() {
		// TODO Auto-generated constructor stub
	}

	public ChambreDouble(int numeroChambre, String description) {
		super(numeroChambre, description);
		// TODO Auto-generated constructor stub
		this.prix=100.0;
	}


	//=============
	//Getters and setters
	//=============
	
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
}
