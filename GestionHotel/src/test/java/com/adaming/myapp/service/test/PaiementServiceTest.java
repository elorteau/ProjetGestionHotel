/*
 * PaiementServiceTest
 * Version: 1.0.0
 * Date: 06-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.abstractfactory.IPaiementFactory;
import com.adaming.myapp.abstractfactory.PaiementFactoryImpl;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Chambre;
import com.adaming.myapp.entities.ChambreDouble;
import com.adaming.myapp.entities.ChambreSimple;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Paiement;
import com.adaming.myapp.entities.PaiementCb;
import com.adaming.myapp.entities.PaiementCheque;
import com.adaming.myapp.entities.PaiementEspece;
import com.adaming.myapp.entities.Suite;
import com.adaming.myapp.exceptions.NullListException;
import com.adaming.myapp.service.IChambreService;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IHotelService;
import com.adaming.myapp.service.IPaiementService;

public class PaiementServiceTest {

	//=========================
	// Attributes
	//=========================
	
	private static ClassPathXmlApplicationContext context;
	private static IPaiementFactory paiementFactory;
	private static IPaiementService servicePaiement;
	private static IFactureService serviceFacture;
	private static IHotelService serviceHotel;
	private static IChambreService serviceChambre;
	
	//=========================
	// Before / After
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		paiementFactory = new PaiementFactoryImpl();
		servicePaiement = (IPaiementService)context.getBean("PaiementServiceImpl");
		serviceFacture = (IFactureService)context.getBean("FactureServiceImpl");
		serviceHotel = (IHotelService)context.getBean("HotelServiceImpl");
		serviceChambre = (IChambreService)context.getBean("ChambreServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	//=========================
	// Tests
	//=========================

	@Test
	//@Ignore
	public void testAdd() {
		Facture facture = new Facture();
		Hotel hotel = new Hotel("hotelFacture", new Adresse("rue de la Facture", 75000, "ParisCouteCher", "Dette"), 9);
		List<Chambre> chambres = new ArrayList<Chambre>();
		chambres.add(new ChambreSimple(1, "a"));
		chambres.add(new ChambreDouble(2, "b"));
		chambres.add(new ChambreDouble(3, "c"));
		chambres.add(new Suite(4, "d"));
		for (Chambre chambre:chambres) {
			serviceChambre.add(chambre);
		}
		serviceHotel.save(hotel, chambres);
		serviceFacture.create(facture, hotel.getId());
		try {
			PaiementCb paiementCb = (PaiementCb)paiementFactory.createPaiement("PaiementCb", 1.0, new Date());
			paiementCb.setNumCarte(1111L);
			paiementCb.setTypeCarte("typeCarte");
			PaiementCheque paiementCheque = (PaiementCheque)paiementFactory.createPaiement("PaiementCheque", 1.0, new Date());
			paiementCheque.setNumCheque(2222L);
			paiementCheque.setBanqueCheque("banque");
			PaiementEspece paiementEspece = (PaiementEspece)paiementFactory.createPaiement("PaiementEspece", 1.0, new Date());
			paiementEspece.setDevise("devise");
			servicePaiement.add(paiementCb, facture.getId());
			servicePaiement.add(paiementCheque, facture.getId());
			servicePaiement.add(paiementEspece, facture.getId());
			assertNotNull(paiementCb.getId());
			assertNotNull(paiementCheque.getId());
			assertNotNull(paiementEspece.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			
		}
	}

	@Test
	@Ignore
	public void testGetOne() {
		List<Paiement> paiements = new ArrayList<Paiement>();
		try {
			paiements = servicePaiement.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Paiement paiement = servicePaiement.getOne(paiements.get(0).getId());
		assertNotNull(paiement);
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Paiement> paiements = new ArrayList<Paiement>();
		try {
			paiements = servicePaiement.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertThat(paiements.isEmpty(), IsEqual.equalTo(false));
	}

	@Test
	@Ignore
	public void testUpdate() {
		List<Paiement> paiements = new ArrayList<Paiement>();
		try {
			paiements = servicePaiement.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Paiement paiement = servicePaiement.getOne(paiements.get(0).getId());
		paiement.setCoutTotal(10.0);
		servicePaiement.update(paiement);
		assertThat(paiement.getCoutTotal(), IsEqual.equalTo(servicePaiement.getOne(paiements.get(0).getId()).getCoutTotal()));
	}

}
