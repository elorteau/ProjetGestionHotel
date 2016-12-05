/* Chambre simple
 *Version: 1.0.0
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CS")
public class ChambreSimple extends Chambre{
	
		//=============
		//attributes
		//=============
		private Double prix;
		
		//=============
		//constructors
		//=============
		public ChambreSimple() {
			// TODO Auto-generated constructor stub
		}

		public ChambreSimple(int numeroChambre, String description, Double prix) {
			super(numeroChambre, description);
			// TODO Auto-generated constructor stub
			this.prix=prix;
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
