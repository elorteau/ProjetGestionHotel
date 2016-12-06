package com.adaming.myapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.dao.IHotelDao;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;

public class HotelServiceImpl implements IHotelService{

	private IHotelDao dao;

	public void setDao(IHotelDao dao) {
		this.dao = dao;
	}

	@Override
	public Double beneficeSemestre(Hotel h) {
		//TO MODIFY
		return 0.0;
	}

	@Override
	public Double beneficeAnnee(Hotel h) {
		List<Facture> factures = h.getFactures();
		List<Employe> employes = dao.getEmployes(h.getId());
				
		Date today = new Date();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(today);
		int moisToday = calendar1.get(Calendar.MONTH);
		int yearToday = calendar1.get(Calendar.YEAR);
		
		Double Gain = 0.0;
		Double Perte = 0.0;
		Double Benef = 0.0;
		Long workTime = 0L;
		
		for (Facture f:factures){
			Date date = f.getPaiement().getDate();
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date);
			int yearPayment = calendar2.get(Calendar.YEAR);
		
			if(yearPayment==yearToday){
				Gain = Gain + f.getPaiement().getCoutTotal();
			}
		}
		for (Employe e:employes){
			Date dateEmbauche = e.getDateEmbauche();
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(dateEmbauche);
			int moisEmbauche = calendar3.get(Calendar.MONTH);
			workTime = (today.getTime()-dateEmbauche.getTime())/(1000*3600*140);  //milliseconds -> seconds -> heures -> mois 
			Perte = Perte + workTime*e.getSalaire();
		}
		Benef = Gain - Perte;
		return  Benef ;
	}

	@Override
	public List<Hotel> sortByBenefit(List<Hotel> hotels) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
