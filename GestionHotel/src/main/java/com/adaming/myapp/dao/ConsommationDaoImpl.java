/*
 * ConsommationDaoImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.entities.Consommation;
import com.adaming.myapp.exceptions.NullListException;

public class ConsommationDaoImpl implements IConsommationDao {

	//=========================
	// Attributes
	//=========================
	
	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger("ConsommationDaoImpl");

	//=========================
	// Methods
	//=========================

	@Override
	public Consommation add(Consommation consommation) {
		em.persist(consommation);
		LOGGER.info("<--------------- " + consommation + " added --------------->");
		return consommation;
	}

	@Override
	public Consommation getOne(Long idConsommation) {
		Consommation consommation = em.find(Consommation.class, idConsommation);
		LOGGER.info("<--------------- " + consommation + " found --------------->");
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Consommation> getAll() throws NullListException {
		List<Consommation> consommations = em.createQuery("from Consommation co").getResultList();
		if (consommations.size() <= 0) {
			throw new NullListException("No Consommations recoverd");
		}
		return consommations;
	}

	@Override
	public Consommation update(Consommation consommation) {
		return null;
	}

}
