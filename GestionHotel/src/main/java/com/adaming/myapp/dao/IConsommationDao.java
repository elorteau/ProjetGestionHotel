/*
 * IConsommationDao
 * Version: 1.0.0
 * Date: 05-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Consommation;
import com.adaming.myapp.exceptions.NullListException;

public interface IConsommationDao {
	
	public Consommation add(final Consommation consommation);
	
	public Consommation getOne(final Long idConsommation);
	
	public List<Consommation> getAll() throws NullListException;
	
	public Consommation update(final Consommation consommation);

}
