package com.adaming.myapp.service;

import com.adaming.myapp.dao.IFactureDao;

public class FactureServiceImpl implements IFactureService{
	
	private IFactureDao dao;

	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	
}
