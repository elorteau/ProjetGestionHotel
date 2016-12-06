package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Consommation;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Personne;
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
	public Facture remplir(Facture f,Long idReservation, Long idConsommation) {
		// TODO Auto-generated method stub
		Reservation r = em.find(Reservation.class, idReservation);
		Consommation c = em.find(Consommation.class, idConsommation);
		f.getReservations().add(r);
		f.getConsommations().add(c);
		em.merge(f);
		LOGGER.info("La facture a été remplie avec la réservation "+idReservation+" et la consommation "+idConsommation);
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
