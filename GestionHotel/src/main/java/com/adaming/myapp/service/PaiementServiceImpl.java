/*
 * PaiementServiceImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IPaiementDao;

@Transactional
public class PaiementServiceImpl implements IPaiementService {

	//=========================
	// Attributes
	//=========================
	
	private IPaiementDao dao;

	//=========================
	// Getter / Setter
	//=========================

	public void setDao(IPaiementDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================

}
