/*
 * ProduitServiceImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IProduitDao;

@Transactional
public class ProduitServiceImpl implements IProduitService {

	//=========================
	// Attributes
	//=========================
	
	private IProduitDao dao;

	//=========================
	// Getter / Setter
	//=========================
	
	public void setDao(IProduitDao dao) {
		this.dao = dao;
	}	

	//=========================
	// Methods
	//=========================

}
