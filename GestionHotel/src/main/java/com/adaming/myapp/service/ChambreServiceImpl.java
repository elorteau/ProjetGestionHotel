package com.adaming.myapp.service;

import com.adaming.myapp.dao.IChambreDao;

public class ChambreServiceImpl implements IChambreService{

	private IChambreDao dao;

	public void setDao(IChambreDao dao) {
		this.dao = dao;
	}
}
