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
import com.adaming.myapp.entities.Paiement;
import com.adaming.myapp.entities.PaiementCb;
import com.adaming.myapp.entities.PaiementCheque;
import com.adaming.myapp.entities.PaiementEspece;
import com.adaming.myapp.exceptions.NullListException;
import com.adaming.myapp.service.IPaiementService;

public class PaiementServiceTest {

	//=========================
	// Attributes
	//=========================
	
	private static ClassPathXmlApplicationContext context;
	private static IPaiementFactory paiementFactory;
	private static IPaiementService servicePaiement;
	
	//=========================
	// Before / After
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		paiementFactory = new PaiementFactoryImpl();
		servicePaiement = (IPaiementService)context.getBean("PaiementServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	//=========================
	// Tests
	//=========================

	@Test
	@Ignore
	public void testAdd() {
		try {
			PaiementCb paiementCb = (PaiementCb)paiementFactory.createPaiement("PaiementCb", 1.0, new Date());
			paiementCb.setNumCarte(1111L);
			paiementCb.setTypeCarte("typeCarte");
			PaiementCheque paiementCheque = (PaiementCheque)paiementFactory.createPaiement("PaiementCheque", 1.0, new Date());
			paiementCheque.setNumCheque(2222L);
			paiementCheque.setBanqueCheque("banque");
			PaiementEspece paiementEspece = (PaiementEspece)paiementFactory.createPaiement("PaiementEspece", 1.0, new Date());
			paiementEspece.setDevise("devise");
			servicePaiement.add(paiementCb);
			servicePaiement.add(paiementCheque);
			servicePaiement.add(paiementEspece);
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
