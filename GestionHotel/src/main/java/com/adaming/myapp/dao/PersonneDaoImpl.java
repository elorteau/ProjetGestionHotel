/*
 * PersonneDaoImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonneDaoImpl implements IPersonneDao {

	//=========================
	// Attributes
	//=========================

	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger("PersonneDaoImpl");

	//=========================
	// Methods
	//=========================

}
