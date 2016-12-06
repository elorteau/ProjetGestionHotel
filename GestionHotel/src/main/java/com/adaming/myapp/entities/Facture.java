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
	   
	   public Facture(Client c, Employe e, double coutReservation,
				double coutConsommation) {
			super();
			CoutReservation = coutReservation;
			CoutConsommation = coutConsommation;
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
}
