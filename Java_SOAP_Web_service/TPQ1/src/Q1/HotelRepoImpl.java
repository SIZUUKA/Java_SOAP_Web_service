package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class HotelRepoImpl implements IHotelRepo {
	/* ATTRIBUTES */
	private ArrayList<Hotel> hotelCollection = new ArrayList<>();
	
	/* CONSTRUCTORS */
	public HotelRepoImpl() {
//		Adresse(String pays, String ville, int numero, String codePostale, String nom, AdresseType type, GPS gps)
		// Hotel(1, "Campanile Montpellier Est Le MillÃ©naire")
		GPS gps1 = new GPS(43.60921999607663, 3.9145600068916337);
		Adresse adresse1 = new Adresse("France", "Montpellier", 1083, "34000", "Henri Becquerel", AdresseType.rue, gps1);
		ArrayList<Lit> litCollection1_1 = new ArrayList<>();
		litCollection1_1.addAll(Arrays.asList(
			new Lit("lit jumeaux", 1),
			new Lit("lit jumeaux", 1)
		));
		ArrayList<Lit> litCollection1_2 = new ArrayList<>();
		litCollection1_2.addAll(Arrays.asList(
			new Lit("lit double", 2)
		));
		ArrayList<Lit> litCollection1_3 = new ArrayList<>();
		litCollection1_3.addAll(Arrays.asList(
			new Lit("lit simple", 1),
			new Lit("lit double", 2)
		));
		ArrayList<Chambre> chambreCollection1 = new ArrayList<>(); 
		chambreCollection1.addAll(Arrays.asList(
			new Chambre(1, 79, 17, litCollection1_1),
			new Chambre(2, 83, 17, litCollection1_2),
			new Chambre(3, 83, 17, litCollection1_3)
		));
//		Chambre(int chambreId, String chambreType, double prix, double taille, List<Lit> litCollection)	
		
		// Hotel(2, "Hotel Regina Louvre")
		GPS gps2 = new GPS(48.86380999296151, 2.3324799734784563);
		Adresse adresse2 = new Adresse("France", "Paris", 2, "75001", "des Pyramides", AdresseType.place, gps2);
		ArrayList<Lit> litCollection2_1 = new ArrayList<>();
		litCollection2_1.addAll(Arrays.asList(
			new Lit("grand lit double", 2)
		));
		ArrayList<Lit> litCollection2_2 = new ArrayList<>();
		litCollection2_2.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		ArrayList<Lit> litCollection2_3 = new ArrayList<>();
		litCollection2_3.addAll(Arrays.asList(
			new Lit("tres grand lit double", 2),
			new Lit("canape-lit", 1)
		));
		ArrayList<Lit> litCollection2_4 = new ArrayList<>();
		litCollection2_4.addAll(Arrays.asList(
			new Lit("grand lit double", 2),
			new Lit("lit simple", 1),
			new Lit("lit simple", 1)
		));
		ArrayList<Chambre> chambreCollection2 = new ArrayList<>(); 
		chambreCollection2.addAll(Arrays.asList(
			new Chambre(1, 422, 25, litCollection2_1),
			new Chambre(2, 768, 60, litCollection2_2),
			new Chambre(3, 877, 50, litCollection2_3),
			new Chambre(4, 818, 50, litCollection2_4)
		));
		
		hotelCollection.addAll(Arrays.asList(
			new Hotel(1, "Campanile Montpellier Est Le Millénaire", 3, adresse1, chambreCollection1),
			new Hotel(2, "Hotel Regina Louvre", 5, adresse2, chambreCollection2)
		));
	}
//	public Hotel(int hotelId, String nom, int categorie, Adresse adresse, ArrayList<Chambre> chambres) 
	@Override
	public int count() {
		return this.hotelCollection.size();
	}

	@Override
	public List<Hotel> getHotelCollection() {
		return this.hotelCollection;
	}

	@Override
	public Hotel getHotel(int id) {
		for (Hotel hotel : this.hotelCollection) {
			if (hotel.getHotelId() == id) {
				return hotel;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "HotelRepoImpl [hotelCollection=" + hotelCollection + "]";
	}
	
	public HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose(String ville, Calendar dateArrivee, Calendar dateDepart, 
			double min, double max, int categorie, int nombrePerson) {
		HashMap<Hotel, ArrayList<Chambre>> propse = new HashMap<Hotel, ArrayList<Chambre>>();
		ArrayList<Hotel> hotelCorres = this.hotelsCorrespond(ville, categorie);
		for (Hotel hotel : hotelCorres) {
			ArrayList<Chambre> chambresPropose = hotel.chambresPropose(dateArrivee, dateDepart, min, max, nombrePerson);
			if (chambresPropose.size() > 0) {
				propse.put(hotel, chambresPropose);
			}
		}
		return propse;
	}
	
	public ArrayList<Hotel> hotelsCorrespond(String ville, int categorie) {
		ArrayList<Hotel> hotelCorres = new ArrayList<>();
		for (Hotel hotel : this.hotelCollection) {
			if (hotel.getAdresse().getVille().equals(ville) && hotel.getCategorie() == categorie) {
				hotelCorres.add(hotel);
			}
		}
		return hotelCorres;
	}

	
		
}
