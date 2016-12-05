/*
 * Client
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne {

	//=========================
	// Attributes
	//=========================
	
	private int reduction;
	
	@OneToMany(mappedBy = "clients")
	private List<Reservation> reservations;
	
	@OneToMany(mappedBy = "clients")
	private List<Consommation> consommation;
	
	//=========================
	// Constructor
	//=========================

	public Client() {
		super();
		reduction = 0;
	}

	public Client(String nom, String prenom, Date dateNaissance, Adresse adresse) {
		super(nom, prenom, dateNaissance, adresse);
		reduction = 0;
	}

	//=========================
	// Getter / Setter
	//=========================

	public int getReduction() {
		return reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Consommation> getConsommation() {
		return consommation;
	}

	public void setConsommation(List<Consommation> consommation) {
		this.consommation = consommation;
	}

	//=========================
	// Methods
	//=========================

	@Override
	public String toString() {
		return "Client [reduction=" + reduction + ", reservations="
				+ reservations + ", consommation=" + consommation
				+ ", idPersonne=" + idPersonne + ", nom=" + nom + ", prenom="
				+ prenom + ", dateNaissance=" + dateNaissance + ", adresse="
				+ adresse + "]";
	}

}
