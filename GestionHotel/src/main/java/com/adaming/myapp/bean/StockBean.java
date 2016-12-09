package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.service.IHotelService;
import com.adaming.myapp.service.IProduitService;

@Component("stockBean")
@ViewScoped
public class StockBean {
	
	private Long id;
	private String nom;
	private int quantite;
	private double coutAchat;
	private double coutVente;
	
	

	

	@Inject 
	private IHotelService hotelService;
	
	@Inject 
	private IProduitService produitService;
	
	


	private Set<Produit> produits = new HashSet<Produit>();
	
	private List<Hotel> hotels = new ArrayList<Hotel>();
	
	@PostConstruct
	public void getAll(){
		setHotels(hotelService.getHotels());
	}

	public void saveProduit() {
		produitService.add(new Produit(nom, quantite, coutAchat, coutVente), id);
		setProduits(hotelService.getProduits(id));
		System.out.println(hotelService.getProduits(id));
		System.out.println(produits);
	}

	
	public String redirect(){
		return "stock";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getCoutAchat() {
		return coutAchat;
	}


	public void setCoutAchat(double coutAchat) {
		this.coutAchat = coutAchat;
	}


	public double getCoutVente() {
		return coutVente;
	}


	public void setCoutVente(double coutVente) {
		this.coutVente = coutVente;
	}


	public Set<Produit> getProduits() {
		return produits;
	}


	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}


	public IProduitService getProduitService() {
		return produitService;
	}


	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}


	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
}

