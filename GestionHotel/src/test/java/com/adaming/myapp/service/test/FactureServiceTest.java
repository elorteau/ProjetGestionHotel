package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.exceptions.NullListException;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IHotelService;

public class FactureServiceTest {

	//=========================
	// Attributes
	//=========================
	
	private static ClassPathXmlApplicationContext context;
	private static IFactureService serviceFacture;
	private static IHotelService serviceHotel;
	
	//=========================
	// Before / After
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceFacture = (IFactureService)context.getBean("FactureServiceImpl");
		serviceHotel = (IHotelService)context.getBean("HotelServiceImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	//=========================
	// Tests
	//=========================

	@Test
	public void testCreate() {
		Facture facture = new Facture();
	}

	@Test
	public void testRemplirReservation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemplirConsommation() {
		fail("Not yet implemented");
	}

	@Test
	public void testImprimer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		List<Facture> factures = new ArrayList<Facture>();
		try {
			factures = serviceFacture.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertThat(factures.isEmpty(), IsEqual.equalTo(false));
	}

}
