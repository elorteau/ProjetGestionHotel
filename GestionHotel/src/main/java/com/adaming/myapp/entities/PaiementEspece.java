package com.adaming.myapp.entities;
/* PaiementEspece
*  Version: 1.0.0
*  Date: 05-12-2016
*  Author: Brice Touchard
*/	
public class PaiementEspece {

	//=========================
	// Attributes
	//=========================
		private int devise;
		
   
	//=========================
	// Constructor
	//=========================
		public PaiementEspece() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PaiementEspece(int devise) {
			super();
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

