package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.dao.IFactureDao;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.exceptions.NullListException;

public class FactureServiceImpl implements IFactureService{
	
	private IFactureDao dao;

	public void setDao(IFactureDao dao) {
		this.dao = dao;
	}

	@Override
	public Facture create(Facture f, Long idHotel) {
		// TODO Auto-generated method stub
		return dao.create(f, idHotel);
	}

	@Override
	public Facture remplir(Facture f, Long idReservation, Long idConsommation) {
		// TODO Auto-generated method stub
		return dao.remplir(f, idReservation, idConsommation);
	}

	@Override
	public Facture imprimer(Long idFacture) {
		// TODO Auto-generated method stub
		return dao.imprimer(idFacture);
	}

	@Override
	public List<Facture> getAll() throws NullListException {
		// TODO Auto-generated method stub
		List<Facture> factures = dao.getAll();
		if (factures.size()==0){
			throw new NullListException("Aucune facture");}
		else{
			return dao.getAll();
		}
	}


	
	

	
}
