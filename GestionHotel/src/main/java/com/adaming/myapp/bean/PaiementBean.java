/*
 * PaiementBean
 * Version: 1.0.0
 * Date: 08-12-2016
 * Author: Etienne Lorteau
 */

package com.adaming.myapp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.adaming.myapp.abstractfactory.IPaiementFactory;
import com.adaming.myapp.abstractfactory.PaiementFactoryImpl;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Facture;
import com.adaming.myapp.entities.Hotel;
import com.adaming.myapp.entities.PaiementCb;
import com.adaming.myapp.entities.PaiementCheque;
import com.adaming.myapp.entities.PaiementEspece;
import com.adaming.myapp.entities.Personne;
import com.adaming.myapp.service.IFactureService;
import com.adaming.myapp.service.IHotelService;
import com.adaming.myapp.service.IPaiementService;
import com.adaming.myapp.service.IPersonneService;

@Component("paiementBean")
@ViewScoped
public class PaiementBean {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("PaiementBean");
	
	private IPaiementFactory paiementFactory;
	
	@Inject
	private IPaiementService servicePaiement;
	
	@Inject
	private IHotelService serviceHotel;
	
	@Inject
	private IPersonneService servicePersonne;
	
	@Inject
	private IFactureService serviceFacture;
	
	// Hotel
	private List<Hotel> hotels;
	private Long idHotel;
	
	// Client
	private List<Client> clients;
	private Long idClient;
	
	// Facture
	private List<Facture> factures;
	private Long idFacture;
	private HashMap<String, Long> refFacture;
	private Facture selectedFacture;
	private String nomClient;
	private String prenomClient;
	private Date dateEntree;
	private Date dateSortie;
	private Double montantFacture;
	
	// Paiement
	private Long numCarte;
	private String typeCarte;
	private Long numCheque;
	private String banqueCheque;
	private String devise;
	
	//=========================
	// Constructor / Service Setter
	//=========================
	
	public PaiementBean() {
		paiementFactory = new PaiementFactoryImpl();
		idHotel = 0L;
		idClient = 0L;
		idFacture = 0L;
		initFields();
		LOGGER.info("<=============== PaiementBean initialized ===============>");
	}

	//=========================
	// Methods
	//=========================
	
	@PostConstruct
	public void initList() {
		hotels = serviceHotel.getHotels();
		clients = new ArrayList<Client>();
		try {
			List<Personne> personnes = servicePersonne.getAll();
			for (Personne personne:personnes) {
				if (personne.getClass() == Client.class) {
					clients.add((Client)personne);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		factures = new ArrayList<Facture>();
		try {
			List<Facture> facturesTmp = serviceFacture.getAll();
			for (Facture facTmp:facturesTmp) {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + facTmp.getPaiement());
				if (facTmp.getPaiement() == null) {
					factures.add(facTmp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		refFacture = new HashMap<String, Long>();
		for (Facture facture:factures) {
			try {
				refFacture.put(facture.getReservations().get(0).getDateArrivee().toString(), facture.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("<=============== Paiement Lists initialized ===============>");
	}
	
	public void initFields() {
		numCarte = null;
		typeCarte = null;
		numCheque = null;
		banqueCheque = null;
		devise = null;
		LOGGER.info("<=============== Paiement Fields initialized ===============>");
	}
	
	public void selectHotel() {
		idClient = 0L;
		idFacture = 0L;
		clients = serviceHotel.getClients(idHotel);
		factures = new ArrayList<Facture>();
		for (Client client:clients) {
			try {
				List<Facture> factureClient = servicePersonne.getFacturesByClient(client.getIdPersonne());
				for (Facture facClient:factureClient) {
					if (facClient.getPaiement() == null) {
						factures.add(facClient);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		refFacture = new HashMap<String, Long>();
		for (Facture facture:factures) {
			try {
				refFacture.put(facture.getReservations().get(0).getDateArrivee().toString(), facture.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("<=============== Hotel Selected for Paiement ===============>");
	}
	
	public void selectClient() {
		idFacture = 0L;
		factures = new ArrayList<Facture>();
		try {
			List<Facture> facturesTmp = servicePersonne.getFacturesByClient(idClient);
			for (Facture facTmp:facturesTmp) {
				if(facTmp.getPaiement() == null) {
					factures.add(facTmp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		refFacture = new HashMap<String, Long>();
		for (Facture facture:factures) {
			refFacture.put(facture.getReservations().get(0).getDateArrivee().toString(), facture.getId());
		}
		LOGGER.info("<=============== Client Selected for Paiement ===============>");
	}
	
	public void selectFacture() {
		selectedFacture = serviceFacture.imprimer(idFacture);
		try {
			idHotel = selectedFacture.getHotel().getId();
			nomClient = selectedFacture.getReservations().get(0).getPersonne().getNom();
			prenomClient = selectedFacture.getReservations().get(0).getPersonne().getPrenom();
			dateEntree = selectedFacture.getReservations().get(0).getDateArrivee();
			dateSortie = selectedFacture.getReservations().get(0).getDateSortie();
			montantFacture = selectedFacture.getCoutConsommation() + selectedFacture.getCoutReservation();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("<=============== Facture Selected for Paiement ===============>");
	}
	
	public void addPaiementCb() {
		try {
			PaiementCb paiementCb = (PaiementCb)paiementFactory.createPaiement("PaiementCb", new Date());
			paiementCb.setCoutTotal(montantFacture);
			paiementCb.setNumCarte(numCarte);
			paiementCb.setTypeCarte(typeCarte);
			servicePaiement.add(paiementCb, selectedFacture.getId());
			LOGGER.info("<=============== Paiement CB done ===============>");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("<=============== Paiement failed ===============>");
		}
	}
	
	public void addPaiementCheque() {
		try {
			PaiementCheque paiementCheque = (PaiementCheque)paiementFactory.createPaiement("PaiementCheque", new Date());
			paiementCheque.setCoutTotal(montantFacture);
			paiementCheque.setNumCheque(numCheque);
			paiementCheque.setBanqueCheque(banqueCheque);
			servicePaiement.add(paiementCheque, selectedFacture.getId());
			LOGGER.info("<=============== Paiement Cheque done ===============>");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("<=============== Paiement failed ===============>");
		}
	}
	
	public void addPaiementEspece() {
		try {
			PaiementEspece paiementEspece = (PaiementEspece)paiementFactory.createPaiement("PaiementEspece", new Date());
			paiementEspece.setCoutTotal(montantFacture);
			paiementEspece.setDevise(devise);
			servicePaiement.add(paiementEspece, selectedFacture.getId());
			LOGGER.info("<=============== Paiement CB done ===============>");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("<=============== Paiement failed ===============>");
		}
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public HashMap<String, Long> getRefFacture() {
		return refFacture;
	}

	public void setRefFacture(HashMap<String, Long> refFacture) {
		this.refFacture = refFacture;
	}

	public Facture getSelectedFacture() {
		return selectedFacture;
	}

	public void setSelectedFacture(Facture selectedFacture) {
		this.selectedFacture = selectedFacture;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Double montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Long getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(Long numCarte) {
		this.numCarte = numCarte;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public Long getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(Long numCheque) {
		this.numCheque = numCheque;
	}

	public String getBanqueCheque() {
		return banqueCheque;
	}

	public void setBanqueCheque(String banqueCheque) {
		this.banqueCheque = banqueCheque;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

}
