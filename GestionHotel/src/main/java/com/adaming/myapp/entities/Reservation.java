/* Reservation
 *Version: 1.0.0
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	//=============
	//attributes
	//=============
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dateArrivee;
	private Date dateSortie;
	
	
	//=============
	//constructors
	//=============
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date dateArrivee, Date dateSortie) {
		super();
		this.dateArrivee = dateArrivee;
		this.dateSortie = dateSortie;
	}


	
	//=============
	//getters and setters
	//=============
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	
	
	
}
