package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.abstractfactory.IPersonneFactory;
import com.adaming.myapp.abstractfactory.PersonneFactoryImpl;
import com.adaming.myapp.entities.Adresse;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.exceptions.NonValidClassTypeException;
import com.adaming.myapp.exceptions.NullListException;
import com.adaming.myapp.service.IHotelService;
import com.adaming.myapp.service.IPersonneService;
import com.adaming.myapp.service.IReservationService;

@Component("reservationBean")
@ViewScoped
public class ReservationBean {
	
	private Long id;
	private String hotel;
	private String nom;
	private String prenom;
	private String rue;
	private int codePostal;
	private String ville;
	private String pays; 
	
	@Inject
	private IReservationService reservationService;
	
	
	
	@Inject 
	private IHotelService hotelService;
	
	@Inject
	private IPersonneService personneService;

	private IPersonneFactory factory = new PersonneFactoryImpl();
	private List<Reservation> reservations = new ArrayList<Reservation>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private List<Client> clients = new ArrayList<Client>();
	
	@PostConstruct
	public void getAll() throws NullListException{
		setHotels(hotelService.getHotels());
		setReservations(reservationService.getAll());
	}
	

	public void saveClient() throws NonValidClassTypeException{
		System.out.println("id : "+id);
		Adresse a = new Adresse(rue, codePostal, ville, pays);
		Client c = (Client)factory.createPersonne("Client", nom, prenom, new Date(), a);
		personneService.create(c);
		hotelService.addPersonne(id, c.getIdPersonne());
	}
	
	public String redirect(){
		return "Reservation";
	}
	public IReservationService getReservationService() {
		return reservationService;
	}
	public void setReservationService(IReservationService reservationService) {
		this.reservationService = reservationService;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	public IPersonneService getPersonneService() {
		return personneService;
	}

	public void setPersonneService(IPersonneService personneService) {
		this.personneService = personneService;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
