/*
 * IPaiementDao
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Paiement;

public interface IPaiementDao {
	
	public Paiement add(final Paiement paiement);
	
	public Paiement getOne(final Long idPaiement);
	
	public List<Paiement> getAll();
	
	public Paiement update(final Paiement paiement);

}
