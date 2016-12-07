/* Hotel
 *Version: 1.0.1
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
	private Adresse adresse;
	private int nombreEtoiles;

	//=============
	//association
	//=============
	@OneToMany
	@JoinColumn(name="PRODUITS_HO")
	private List<Produit> produits;
	@OneToMany
	@JoinColumn(name="PERSONNES_HO")
	private List<Personne> personnes;
	@OneToMany(mappedBy="hotel", fetch = FetchType.EAGER)
	private List<Facture> factures;
	@OneToMany
	@JoinColumn(name="CHAMBRES_HO")
	private List<Chambre> chambres;
	@OneToMany
	@JoinColumn(name="RESERVATIONS_HO")
	private List<Reservation> reservations;
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
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
