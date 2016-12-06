package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.exceptions.NullListException;

public interface IFactureService {
	
	public Facture create (Facture f, Long idHotel);
	public Facture remplir (Facture f, Long idReservation, Long idConsommation);
	public Facture imprimer(Long idFacture);
	public List<Facture> getAll() throws NullListException;

}
