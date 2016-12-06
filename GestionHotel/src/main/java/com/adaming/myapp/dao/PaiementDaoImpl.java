/*
 * PaiementDaoImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Paiement;

public class PaiementDaoImpl implements IPaiementDao {

	//=========================
	// Attributes
	//=========================

	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger("PaiementDaoImpl");

	//=========================
	// Methods
	//=========================

	@Override
	public Paiement add(Paiement paiement) {
		em.persist(paiement);
		LOGGER.info("<--------------- " + paiement + " added --------------->");
		return paiement;
	}

	@Override
	public Paiement getOne(Long idPaiement) {
		Paiement paiement = em.find(Paiement.class, idPaiement);
		LOGGER.info("<--------------- " + paiement + " found --------------->");
		return paiement;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Paiement> getAll() {
		List<Paiement> paiements = em.createQuery("from Paiement pa").getResultList();
		LOGGER.info("<--------------- List of Paiement recoverd --------------->");
		return paiements;
	}

	@Override
	public Paiement update(Paiement paiement) {
		em.merge(paiement);
		LOGGER.info("<--------------- " + paiement + " updated --------------->");
		return paiement;
	}

}
