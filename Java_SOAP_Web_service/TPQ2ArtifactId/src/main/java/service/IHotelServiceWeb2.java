package service;

import java.util.Calendar;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import model.Agence;
import model.CarteCredit;
import model.Chambre;
import model.Client;
import model.HotelPartenaireTarif;
import model.Reservation;

@WebService
public interface IHotelServiceWeb2 {
	@WebMethod
	Agence agenceLoginRes(String identifiant, String mdp);
	
	@WebMethod
	void reserve(HotelPartenaireTarif hotelPartenaireTarif, Reservation res, Agence agence);
	
	@WebMethod
	CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee);
	
	@WebMethod
	Client createClient(String nom, String prenom, CarteCredit carteCredit);
	
	@WebMethod
	Reservation createReservation(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, List<Chambre> chambreChoisi, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence);
	
}