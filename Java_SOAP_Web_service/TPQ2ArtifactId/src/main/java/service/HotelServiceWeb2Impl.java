package service;

import java.util.Calendar;
import java.util.List;

import javax.jws.WebService;

import model.CarteCredit;
import model.Agence;
import model.Chambre;
import model.Client;
import model.HotelPartenaireTarif;
import model.Reservation;
import repository.IRepoPlateforme;
import repository.RepoPlateformeImpl;

@WebService(endpointInterface="service.IHotelServiceWeb2")
public class HotelServiceWeb2Impl implements IHotelServiceWeb2 {
	/* ATTRIBUTES */
	private IRepoPlateforme repoPlateformeImpl = new RepoPlateformeImpl();

	/* METHODS */
	@Override
	public Agence agenceLoginRes(String identifiant, String mdp) {
		return repoPlateformeImpl.agenceLogin(identifiant, mdp);
	}
	
	@Override
	public void reserve(HotelPartenaireTarif hotelPartenaireTarif, Reservation res, Agence agence) {
		repoPlateformeImpl.reserve(hotelPartenaireTarif, res, agence);
	}
	
	@Override
	public CarteCredit createCarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee) {
		return repoPlateformeImpl.createCarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
	}
	
	@Override
	public Client createClient(String nom, String prenom, CarteCredit carteCredit) {
		return repoPlateformeImpl.createClient(nom, prenom, carteCredit);
	}
	
	@Override
	public Reservation createReservation(HotelPartenaireTarif hotelPartenaireTarif, String reservationId, List<Chambre> chambreChoisi, Calendar dateArrivee, Calendar dateDepart,
			Client client, double prix, Agence agence) {
		return repoPlateformeImpl.createReservation(hotelPartenaireTarif, reservationId, chambreChoisi, dateArrivee, dateDepart,
			 client, prix, agence);
	}

}
