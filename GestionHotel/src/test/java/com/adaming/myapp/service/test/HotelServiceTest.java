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
		
		
	
	
	
}
