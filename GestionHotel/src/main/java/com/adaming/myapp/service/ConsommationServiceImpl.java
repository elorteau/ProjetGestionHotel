/*
 * ConsommationServiceImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IConsommationDao;

@Transactional
public class ConsommationServiceImpl implements IConsommationService {

	//=========================
	// Attributes
	//=========================
	
	private IConsommationDao dao;
	
	//=========================
	// Getter / Setter
	//=========================

	public void setDao(IConsommationDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================

}
