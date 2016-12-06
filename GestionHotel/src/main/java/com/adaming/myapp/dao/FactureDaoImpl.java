package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Consommation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Reservation;

public class FactureDaoImpl implements IFactureDao{
	
	//=========================
	// Attributes
	//=========================

	private final Logger LOGGER = Logger.getLogger("FactureDaoImpl");

	@PersistenceContext
	private EntityManager em;


	//=========================
	// Methods
	//=========================
	
	@Override
	public Facture create(Facture f, Long idHotel) {
		// TODO Auto-generated method stub
		Hotel h = em.find(Hotel.class, idHotel);
		f.setHotel(h);
		em.persist(f);
		LOGGER.info("La facture a été crée pour l'hôtel "+idHotel);
		return f;
	}
	
	@Override
	public Facture remplirReservation(Long idFacture, Long idReservation) {
		Facture f = em.find(Facture.class, idFacture);
		Reservation r = em.find(Reservation.class, idReservation);
		f.getReservations().add(r);
		f.setCoutReservation(f.getCoutReservation() + r.getChambre().getPrix());
		r.setFacture(f);
		em.merge(f);
		em.merge(r);
		LOGGER.info("La facture a été remplie avec la réservation "+idReservation);
		return f;	
	}
	
	@Override
	public Facture remplirConsommation(Long idFacture, Long idConsommation) {
		Facture f = em.find(Facture.class, idFacture);
		Consommation c = em.find(Consommation.class, idConsommation);
		f.getConsommations().add(c);
		f.setCoutConsommation(f.getCoutConsommation() + c.getQuantite() * c.getProduit().getCoutVente());
		em.merge(f);
		LOGGER.info("La facture a été remplie avec la consommation "+idConsommation);
		return f;
	}

	@Override
	public Facture imprimer(Long idFacture) {
		// TODO Auto-generated method stub
		Facture f = em.find(Facture.class, idFacture);
		LOGGER.info("La facture a été trouvée");
		return f;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> getAll() {
		// TODO Auto-generated method stub
		List<Facture> factures = em.createQuery("from Facture f").getResultList();
		return factures;
	}



	

	
	
}
