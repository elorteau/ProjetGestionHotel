/*
 * ProduitServiceTest
 * Version: 1.0.0
 * Date: 06-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.exceptions.NullListException;
import com.adaming.myapp.service.IProduitService;

public class ProduitServiceTest {

	//=========================
	// Attributes
	//=========================
	
	private static ClassPathXmlApplicationContext context;
	private static IProduitService serviceProduit;
	
	//=========================
	// Before / After
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceProduit = (IProduitService)context.getBean("ProduitServiceImpl");
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
		Produit produit = new Produit("nom", 1, 10.0, 15.0);
		serviceProduit.add(produit);
		assertNotNull(produit.getIdProduit());
	}

	@Test
	@Ignore
	public void testGetOne() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			produits = serviceProduit.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Produit produit = serviceProduit.getOne(produits.get(0).getIdProduit());
		assertNotNull(produit);
	}

	@Test
	@Ignore
	public void testGetAll() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			produits = serviceProduit.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		assertThat(produits.isEmpty(), IsEqual.equalTo(false));
	}

	@Test
	@Ignore
	public void testUpdate() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			produits = serviceProduit.getAll();
		} catch (NullListException e) {
			e.printStackTrace();
		}
		Produit produit = serviceProduit.getOne(produits.get(0).getIdProduit());
		produit.setNom("nouveau nom");
		serviceProduit.update(produit);
		assertThat(produit.getNom(), IsEqual.equalTo(serviceProduit.getOne(produits.get(0).getIdProduit()).getNom()));
	}

}
