package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Hotel {
	// attribut
	private int hotelId;
	private String nom;
	private int categorie;
	private Adresse adresse;
	private ArrayList<Chambre> chambreCollection = new ArrayList<>();
	private ArrayList<Reservation> reservCollection = new ArrayList<>();
	
	private ArrayList<ArrayList<Chambre>> groupPropose = new ArrayList<ArrayList<Chambre>>();

//	private List<Chambre> chambresDispo; // computed
//	private int hotelCapacite; // computed
	
	// constructeur
	public Hotel(int hotelId, String nom, int categorie, 
			Adresse adresse, ArrayList<Chambre> chambreCollection) {
		super();
		this.hotelId = hotelId;
		this.nom = nom;
		this.categorie = categorie;
		this.adresse = adresse;
		this.chambreCollection = chambreCollection;
	}
	
	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Chambre> getChambreCollection() {
		return chambreCollection;
	}

	public void setChambreCollection(ArrayList<Chambre> chambreCollection) {
		this.chambreCollection = chambreCollection;
	}

	public ArrayList<Reservation> getReservCollection() {
		return reservCollection;
	}

	public void setReservCollection(ArrayList<Reservation> reservCollection) {
		this.reservCollection = reservCollection;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", nom=" + nom + ", categorie=" + categorie + ", adresse=" + adresse
				+ ", chambreCollection=" + chambreCollection + ", reservCollection=" + reservCollection + "]";
	}
	
	public ArrayList<Chambre> chambresDispoDansPeriode(Calendar dateArrivee, Calendar dateDepart) {
		ArrayList<Chambre> chambresDispo = new ArrayList<>();
		chambresDispo.addAll(this.chambreCollection);
		for (Reservation reservation : reservCollection) {
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
	
	//ne proposer qu'une seule combinaison, si plusieurs combinaisons répondent aux critères.
	public ArrayList<Chambre> chambresPropose(Calendar dateArrivee, Calendar dateDepart, 
			double min, double max, int nombrePerson) {
		this.groupPropose.clear();
		ArrayList<Chambre> chambresPropose = new ArrayList<>();
		ArrayList<Chambre> chambresDispo = this.chambresDispoDansPeriode(dateArrivee, dateDepart);
		int hotelCapacite = this.capaciteDeChambresDispo(chambresDispo);

		if (hotelCapacite == nombrePerson) {
			double prix = prixChambresPropose(chambresDispo);
			if (prix >= min && prix <= max) {
				chambresPropose.addAll(chambresDispo);
			}
		} else if (hotelCapacite > nombrePerson) {
			this.sum_up(chambresDispo, nombrePerson);
//			System.err.println("#"+this.groupPropose.toString());
//			System.err.println("#"+this.groupPropose.size());
//			System.err.println("#"+this.groupPropose.get(0).toString());

			for (ArrayList<Chambre> propose : this.groupPropose) {
				double prix = this.prixChambresPropose(propose);
				if (prix >= min && prix <= max) {
					chambresPropose.addAll(propose);
					break;
				}
			}
		}
//		System.err.println("##"+chambresPropose.toString());
		return chambresPropose;
	}
	
	public double prixChambresPropose(ArrayList<Chambre> chambresPropose) {
		double prix = 0;
		for (Chambre c : chambresPropose) {
			prix += c.getPrix();
		}
		return prix;
	}
	
	private void sum_up(ArrayList<Chambre> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Chambre>());
    }
	
	private void sum_up_recursive(ArrayList<Chambre> numbers, int target, ArrayList<Chambre> partial) {
       int s = 0;
       for (Chambre x: partial) s += x.getChambreCapacite();
       if (s == target) {
    	   System.out.println("proposition ("+Arrays.toString(partial.toArray())+")="+target);
    	   this.groupPropose.add(partial);
       }
       if (s >= target) {
           return;
       }
       for(int i=0;i<numbers.size();i++) {
			ArrayList<Chambre> remaining = new ArrayList<Chambre>();
			numbers.get(i).getChambreCapacite();
			for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
			ArrayList<Chambre> partial_rec = new ArrayList<Chambre>(partial);
			partial_rec.add(numbers.get(i));
			sum_up_recursive(remaining,target,partial_rec);
       }
    }

	public void reserve(int reservationId, ArrayList<Chambre> chambreChoisi, Calendar dateArrivee, Calendar dateDepart, Client client, double prix) {
		Reservation res = new Reservation(reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix);
		this.reservCollection.add(res);
	}
}
