package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Hotel;

public interface IHotelService {

	Double beneficeSemestre(Hotel h);
	
	Double beneficeAnnee(Hotel h);
	
	List<Hotel> sortByBenefit(List<Hotel> hotels);
	
	
}
