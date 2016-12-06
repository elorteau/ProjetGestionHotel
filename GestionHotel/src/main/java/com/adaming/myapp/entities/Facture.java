package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.*;

/*
* Facture
* Version: 1.0.1
* Date: 05-12-2016
* Author: Brice Touchard
*/	

@Entity
public class Facture {
	
	//=========================
	// Attributes
	//=========================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private double CoutReservation;
	private double CoutConsommation;
   
	@ManyToOne 
	private Hotel hotel;
    
	@OneToMany(mappedBy="facture")
    private List<Reservation> reservations;
    @OneToMany
    @JoinColumn(name="CONSOS_FACT")
    private List<Consommation> consommations;
    @OneToOne
    private Paiement paiement;
	
	//=========================
	// Constructor
	//=========================
	   
   public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}   

	//=========================
	// Getter / Setter
	//=========================
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getCoutReservation() {
		return CoutReservation;
	}
	public void setCoutReservation(double coutReservation) {
		CoutReservation = coutReservation;
	}
	public double getCoutConsommation() {
		return CoutConsommation;
	}
	public void setCoutConsommation(double coutConsommation) {
		CoutConsommation = coutConsommation;
	}
    public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Consommation> getConsommations() {
		return consommations;
	}

	public void setConsommations(List<Consommation> consommations) {
		this.consommations = consommations;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	@Override
	public String toString() {
		return "Facture [id=" + id + ", CoutReservation=" + CoutReservation
				+ ", CoutConsommation=" + CoutConsommation + "]";
	}

}
