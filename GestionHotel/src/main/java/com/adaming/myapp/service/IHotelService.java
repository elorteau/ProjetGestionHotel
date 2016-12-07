package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;

public interface IHotelService {

	Hotel save(Hotel h, List<Chambre> chambres);
	// Adresse, List<Chambre>, List<Personne>, List<Reservation>, List<Facture>, List<Produit>,
	Hotel getOne(Long id);
	List<Hotel> getHotels();
	Hotel update(Hotel h);
	
	Hotel addPersonne(Long idHotel, Long idPersonne);
	Hotel addReservation(Long idHotel, Long idReservation);
	Hotel addFacture(Long idHotel, Long idFacture);
	Hotel addProduit(Long idHotel, Long idProduit);
	
	List<Employe> getEmployes(Long idHotel);
	List<Client> getClients(Long idHotel);
	List<Produit> getProduits(Long idHotel);
	
	Double beneficeSemestre(Hotel h);
	Double beneficeAnnee(Hotel h);
	List<Chambre> getChambreDisponible(final Long idHotel,final Date dateArrivee ,final Date dateSortie);
	
}
