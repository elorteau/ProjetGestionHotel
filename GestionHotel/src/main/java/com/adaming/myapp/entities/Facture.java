package com.adaming.myapp.entities;
/*
* Facture
* Version: 1.0.0
* Date: 05-12-2016
* Author: Brice Touchard
*/	
public class Facture {
	
	//=========================
	// Attributes
	//=========================
	   private Long id;
	   private Client c;
	   private Employe e;
	   private double CoutReservation;
	   private double CoutConsommation;

	
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
			this.c = c;
			this.e = e;
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
		public Client getC() {
			return c;
		}
		public void setC(Client c) {
			this.c = c;
		}
		public Employe getE() {
			return e;
		}
		public void setE(Employe e) {
			this.e = e;
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
	   	
    //=========================
    // Methods
    //=========================
	
	

}
