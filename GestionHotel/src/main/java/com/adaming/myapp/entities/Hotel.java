/* Hotel
 *Version: 1.0.0
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	//=============
	//attributes
	//=============
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;

	//=============
	//composition
	//=============
	@Embedded
	Adresse adresse;
	private int nombreEtoiles;

	//=============
	//Constructors
	//=============

	public Hotel() {
		// TODO Auto-generated constructor stub
	}

	public Hotel(String nom, Adresse adresse, int nombreEtoiles) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.nombreEtoiles = nombreEtoiles;
	}

	//=============
	//Getters and setters
	//=============
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getNombreEtoiles() {
		return nombreEtoiles;
	}

	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}


}
