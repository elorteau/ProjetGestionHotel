package com.adaming.myapp.service.test;

/* Hotel
 *Version: 1.0.0
 *Date: 06-12-2016
 *Author: Brice Touchard
 */

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.service.IHotelService;

public class HotelServiceTest {

	 private final Logger LOGGER = Logger.getLogger("HotelServiceTest");
		
	 private static ClassPathXmlApplicationContext context;
		
	 private static IHotelService service;

		@BeforeClass 
		public static void setUpBeforeClass() {
		  context= new ClassPathXmlApplicationContext("app.xml");
		  service = (IHotelService) context.getBean("HotelServiceImpl");
		}

		@AfterClass
		public static void tearDownAfterClass() {
		  context.close();
		}
		
		//TEST CRUD
		
		//test Create
		public void testSave() {
			Adresse a1 = new Adresse("1 rue Jean Jaures",75100,"Paris","France");
			Hotel h1 = new Hotel("Le palace",a1,1);
			service.save(h1,liste);
		}
		
	
	
	
}
