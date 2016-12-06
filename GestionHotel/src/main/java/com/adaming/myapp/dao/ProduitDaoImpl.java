/*
 * ProduitDaoImpl
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	//=========================
	// Attributes
	//=========================

	@PersistenceContext
	private EntityManager em;

	private final Logger LOGGER = Logger.getLogger("ProduitDaoImpl");

	//=========================
	// Methods
	//=========================

	@Override
	public Produit add(Produit produit) {
		em.persist(produit);
		LOGGER.info("<--------------- " + produit + " added --------------->");
		return produit;
	}

	@Override
	public Produit getOne(Long idProduit) {
		Produit produit = em.find(Produit.class, idProduit);
		LOGGER.info("<--------------- " + produit + " found --------------->");
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produit> getAll() {
		List<Produit> produits = em.createQuery("from Produit pr").getResultList();
		LOGGER.info("<--------------- List of Produit recoverd --------------->");
		return produits;
	}

	@Override
	public Produit update(Produit produit) {
		em.merge(produit);
		LOGGER.info("<--------------- " + produit + " updated --------------->");
		return produit;
	}

}
