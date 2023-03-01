package repository;

import java.util.Calendar;
import java.util.List;

import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.Propose;
import model.Reservation;
import model.HotelPartenaireTarif;
import model.Lit;

public interface IRepoPlateforme {
	/* METHODS */
	Agence agenceLogin(String identifiant, String mdp);
	
	String getAgenceIdentifiant(Agence agenceLogin);
	
	List<Propose> getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson);
	
	void reserve(HotelPartenaireTarif hotelPartenaireTarif, Reservation res, Agence agence);
	
	double prixChoisi(Propose propose, Agence agenceLogin, int days);
	
	String getHotelNom(Propose propose);

	CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee);

	Client createClient(String nom, String prenom, CarteCredit carteCredit);
	
	List<HotelPartenaireTarif> getAgencePartenaire(Agence agenceLogin);
	
	String getLitDesc(Lit lit);
	
	Reservation createReservation(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, List<Chambre> chambreChoisi, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence);
	
//	List<String> getTest(Calendar cal1, Calendar cal2);
}
