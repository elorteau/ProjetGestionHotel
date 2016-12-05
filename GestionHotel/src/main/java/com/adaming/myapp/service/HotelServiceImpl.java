package com.adaming.myapp.service;

import com.adaming.myapp.dao.IHotelDao;

public class HotelServiceImpl implements IHotelService{

	private IHotelDao dao;

	public void setDao(IHotelDao dao) {
		this.dao = dao;
	}

	
}
