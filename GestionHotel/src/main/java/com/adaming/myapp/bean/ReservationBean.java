package com.adaming.myapp.bean;

import java.text.SimpleDateFormat;
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
import com.adaming.myapp.entities.Chambre;
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
	
	private Long idClient;
	private Long id;
	private Long idChambre;
	private String hotel;
	private String nom;
	private String prenom;
	private String rue;
	private int codePostal;
	private String ville;
	private String pays; 
	private Date dateArrivee=new Date();
	private Date dateDepart=new Date();
	private String Description;
	private int numeroChambre;
	private Double prix;
	
	

	
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
	private List<Chambre> chambres = new ArrayList<Chambre>();
	
	@PostConstruct
	public void getAll() throws NullListException{
		setHotels(hotelService.getHotels());
		setReservations(reservationService.getAll());
	}
	

	public void saveClient() throws NonValidClassTypeException{
		Adresse a = new Adresse(rue, codePostal, ville, pays);
		Client c = (Client)factory.createPersonne("Client", nom, prenom, new Date(), a);
		personneService.create(c);
		hotelService.addPersonne(id, c.getIdPersonne());
		redirect();
	}
	
	public void onChange(){
		setClients(hotelService.getClients(id));
	}
	
	public void saveClient2(){
		setIdClient(idClient);
	}
	
	public void checkDates(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.format(dateDepart);
		format.format(dateArrivee);
		setChambres(hotelService.getChambreDisponible(id, dateArrivee, dateDepart));
		System.out.println(chambres);
		redirect();
	}
	
	public void reserver(){
		Reservation r = new Reservation(dateArrivee, dateDepart);
		reservationService.create(r, id, idChambre, idClient);
		redirect();
	}
	
	public String redirect(){
		return "Reservation?faces-redirect=true";
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


	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public Date getDateArrivee() {
		return dateArrivee;
	}


	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}


	public Date getDateDepart() {
		return dateDepart;
	}


	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}


	public List<Chambre> getChambres() {
		return chambres;
	}


	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public int getNumeroChambre() {
		return numeroChambre;
	}


	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}


	public Double getPrix() {
		return prix;
	}


	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public Long getIdChambre() {
		return idChambre;
	}


	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	
}
