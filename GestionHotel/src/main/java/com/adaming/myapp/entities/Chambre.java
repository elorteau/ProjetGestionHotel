/* Chambre
 *Version: 1.0.0
 *Date: 05-12-2016
 *Author: Guillaume Campo
 */

package com.adaming.myapp.entities;

import javax.annotation.Generated;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Chambre {

	//=============
	//attributes
	//=============
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int numeroChambre;
	private String Description;

	//=============
	//constructors
	//=============
	public Chambre() {
		// TODO Auto-generated constructor stub
	}
	
	public Chambre(int numeroChambre, String description) {
		super();
		this.numeroChambre = numeroChambre;
		this.Description = description;
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
	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}


}
