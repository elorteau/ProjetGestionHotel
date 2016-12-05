package com.adaming.myapp.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReservationDaoImpl implements IReservationDao{
	//=========================
	// Attributes
	//=========================

	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger("ReservationDaoImpl");

	//=========================
	// Methods
	//=========================
}
