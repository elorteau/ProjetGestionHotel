package com.adaming.myapp.entities;
/* Paiement
*  Version: 1.0.0
*  Date: 05-12-2016
*  Author: Brice Touchard
*/	
import java.util.Date;


public class Paiement {

	//=========================
	// Attributes
	//=========================
	   private Long id;
	   private double CoutTotal;
	   private Date date;

	   
	//=========================
	// Constructor
	//=========================
		public Paiement() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Paiement(double coutTotal, Date date) {
			super();
			CoutTotal = coutTotal;
			this.date = date;
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
		public double getCoutTotal() {
			return CoutTotal;
		}
		public void setCoutTotal(double coutTotal) {
			CoutTotal = coutTotal;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}   
}
