package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Hotel {
	private String nom;
	private List<Chambre> chambreCollection = new ArrayList<Chambre>();
	private List<Reservation> reservCollection = new ArrayList<Reservation>();
	
	private List<List<Chambre>> groupPropose = new ArrayList<List<Chambre>>();
	
	public Hotel() {
		super();
	}

	public Hotel(int hotelId, String nom, int categorie, 
			Adresse adresse, List<Chambre> chambreCollection) {
		super();
		this.nom = nom;
		this.chambreCollection = chambreCollection;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Chambre> getChambreCollection() {
		return chambreCollection;
	}

	public void setChambreCollection(List<Chambre> chambreCollection) {
		this.chambreCollection = chambreCollection;
	}

	// propose all the combinations
	public List<List<Chambre>> chambresAllPropose(Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		this.groupPropose.clear();
		List<Chambre> chambresDispo = this.chambresDispoDansPeriode(dateArrivee, dateDepart);
		int hotelCapacite = this.capaciteDeChambresDispo(chambresDispo);
		if (hotelCapacite >= nombrePerson) {
			this.sum_up(chambresDispo, nombrePerson);
			if (this.groupPropose.size() == 0) {
				this.sum_up(chambresDispo, nombrePerson+1);
			}
		}
		return this.groupPropose;
	}
	
	private void sum_up(List<Chambre> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Chambre>());
    }
	
	private void sum_up_recursive(List<Chambre> numbers, int target, List<Chambre> partial) {
       int s = 0;
       for (Chambre x: partial) {
    	   s += x.getChambreCapacite();
       }
       if (s == target) {
    	   System.out.println("proposition ("+Arrays.toString(partial.toArray())+")="+target);
    	   this.groupPropose.add(partial);
       }
       if (s >= target) {
           return;
       }
       for(int i=0;i<numbers.size();i++) {
			List<Chambre> remaining = new ArrayList<Chambre>();
			numbers.get(i).getChambreCapacite();
			for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
			List<Chambre> partial_rec = new ArrayList<Chambre>(partial);
			partial_rec.add(numbers.get(i));
			sum_up_recursive(remaining,target,partial_rec);
       }
    }
		
	public List<Chambre> chambresDispoDansPeriode(Calendar dateArrivee, Calendar dateDepart) {
		List<Chambre> chambresDispo = new ArrayList<Chambre>();
		chambresDispo.addAll(this.chambreCollection);
		for (Reservation reservation : this.reservCollection) {
			if (!(!reservation.getDateArrivee().before(dateDepart) || !reservation.getDateDepart().after(dateArrivee))) {
				for (Chambre cr : reservation.getChambreReserveCollection()) {
					if (chambresDispo.contains(cr)) {
						chambresDispo.remove(cr);
					}
				}
			}
		}
		return chambresDispo;
	}
	
	public int capaciteDeChambresDispo(List<Chambre> chambresDispo) {
		int hotelCapacite = 0;
		for (Chambre c : chambresDispo) {
			hotelCapacite += c.getChambreCapacite();
		}
		return hotelCapacite;
	}
	
	public void reserve(HotelPartenaireTarif hotelPartenaireTarif, Reservation res, Agence agence) {
		this.reservCollection.add(res);
		agence.addReservation(res);
	}
}
