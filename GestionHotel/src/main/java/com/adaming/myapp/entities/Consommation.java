package com.adaming.myapp.entities;

import javax.persistence.*;

/* Consommation
*  Version: 1.0.0
*  Date: 05-12-2016
*  Author: Brice Touchard
*/	

@Entity
public class Consommation {
	
	//=========================
	// Attributes
	//=========================
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private int quantite;
		
		@OneToOne
		private Personne personne;
		@ManyToOne
		private Produit produit;
		@ManyToOne
		private Facture facture;
		
	//=========================
	// Constructor
	//=========================
		public Consommation() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Consommation(int quantite) {
			super();
			this.quantite = quantite;
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
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
}
