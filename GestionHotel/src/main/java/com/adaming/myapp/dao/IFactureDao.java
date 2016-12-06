package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Facture;

public interface IFactureDao {
	
	public Facture create (Facture f, Long idHotel);
	public Facture remplir (Facture f, Long idReservation, Long idConsommation);
	public Facture imprimer(Long idFacture);
	public List<Facture> getAll();


}
