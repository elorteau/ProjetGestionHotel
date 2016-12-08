/*
 * PaiementBean
 * Version: 1.0.0
 * Date: 078-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.bean;

import java.util.logging.Logger;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;

@Component("paiementBean")
@ViewScoped
public class PaiementBean {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("PaiementBean");
	
	//=========================
	// Constructor / Service Setter
	//=========================
	
	//=========================
	// Getter / Setter
	//=========================

	//=========================
	// Methods
	//=========================
	
	public String redirect() {
		LOGGER.info("<=============== redirect to page : paiement ===============>");
		return "paiement";
	}
	
}
