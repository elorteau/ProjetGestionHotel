/*
 * PersonneServiceImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IPersonneDao;

@Transactional
public class PersonneServiceImpl implements IPersonneService {

	//=========================
	// Attributes
	//=========================
	
	private IPersonneDao dao;

	//=========================
	// Getter / Setter
	//=========================

	public void setDao(IPersonneDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================

}
