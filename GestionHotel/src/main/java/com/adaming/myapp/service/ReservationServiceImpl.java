package com.adaming.myapp.service;

import com.adaming.myapp.dao.IReservationDao;

public class ReservationServiceImpl implements IReservationService {

	private IReservationDao dao;

	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}
}
