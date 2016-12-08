package com.adaming.myapp.bean;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.adaming.myapp.service.IHotelService;

@Component("hotelBean")
@ViewScoped
public class HotelBean {
	
	private Logger LOGGER = Logger.getLogger("HotelBean");

	@Inject
	private IHotelService service;
	
	
	public String forward(){
		return "hotel";
	}
	
	public String redirect(){
		return "hotel?faces-redirect=true";
	}
}
