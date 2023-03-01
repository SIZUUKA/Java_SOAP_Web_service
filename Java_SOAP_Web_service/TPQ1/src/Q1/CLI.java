package Q1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class CLI {
	public static final String QUIT = "0";
	public static StringToCalendar inputStringToCalendar;
	public static StringToDouble inputStringToDouble;
	public static StringToInt inputStringToInt;

	public static void main(String[] args) {
		IHotelRepo hotelCollection = new HotelRepoImpl();
		
		CLI main = new CLI();
		BufferedReader inputReader;
		String userInput = "";
		
		inputReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader, userInput, hotelCollection);
				Thread.sleep(1000);
			} while(!userInput.equals(QUIT));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quitter.");
		builder.append("\n1. Afficher tous les hôtels.");
		builder.append("\n2. Afficher la disponibilité de tous les hôtels.");
		System.out.println(builder);
	}
	
	private void processUserInput(BufferedReader reader, 
			String userInput, IHotelRepo hotelCollection) {
		try {
			switch(userInput) {
				case "1":
					hotelCollection.getHotelCollection()
					.forEach(e -> displayHotel(e));
					break;
				case "2":
					System.out.println("Ville: ");
					String ville = reader.readLine();
					System.out.println();
					
					System.out.println("Date d'arrivée (dd/MM/yyyy): ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateArrivee = (Calendar) inputStringToCalendar.process();
					System.out.println();
					
					System.out.println("Date de départ (dd/MM/yyyy): ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateDepart = (Calendar) inputStringToCalendar.process();
					while (!dateDepart.after(dateArrivee)) {
						System.err.println("La date de départ doit être postérieure à la date d'arrivée !");
						System.out.println();
						System.out.println("Date de départ (dd/MM/yyyy): ");
						inputStringToCalendar = new StringToCalendar(reader);
						dateDepart = (Calendar) inputStringToCalendar.process();
					}
					System.out.println();
					
					System.out.println("Prix minimum / nuit: ");
					inputStringToDouble = new StringToDouble(reader);
					double min = (double) inputStringToDouble.process();
					System.out.println();
					
					System.out.println("Prix maximum / nuit : ");
					inputStringToDouble = new StringToDouble(reader);
					double max = (double) inputStringToDouble.process();
					while (max <= min) {
						System.err.println("Le prix maximum doit être supérieur au prix minimum !");
						System.out.println();
						System.out.println("Prix maximum : ");
						inputStringToDouble = new StringToDouble(reader);
						max = (double) inputStringToDouble.process();
					}
					System.out.println();
					
					System.out.println("Catégorie d'hôtel (1,2,3,4,5): ");
					inputStringToInt = new StringToInt(reader);
					int categorie = (int) inputStringToInt.process();
					System.out.println();
				
					System.out.println("Nombre de personnes hébergées: ");
					inputStringToInt = new StringToInt(reader);
					int nombrePerson = (int) inputStringToInt.process();
					System.out.println();
					
					HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose = 
							hotelCollection.hotelChambrePropose(ville, dateArrivee, dateDepart, min, max, categorie, nombrePerson);

					int days = daysBetween(dateArrivee, dateDepart);
					
					if (hotelChambrePropose.size() == 0) {
						System.err.println("Désolé, aucun hôtel ne correspond. essaie une autre fois.");
						break;
					} else {
						System.out.println("Voici tous les propositions : ");
						displayPropose(hotelChambrePropose, days);
						
						// reserver
						System.out.println("Entrez le nom de l'hôtel pour réserver : ");
						String nomHotel = reader.readLine();
						System.out.println();
						HashMap<Hotel, ArrayList<Chambre>> hotelChambreChoisi = getPropose(nomHotel, hotelChambrePropose);
						while (hotelChambreChoisi.size() == 0) {
							System.out.println("Mauvaise saisie, réessayez. Entrez le nom de l'hôtel pour réserver : ");
							nomHotel = reader.readLine();
							System.out.println();
							hotelChambreChoisi = getPropose(nomHotel, hotelChambrePropose);
						}
						
						// Client
						System.out.println("Nom de client principal : ");
						String nom = reader.readLine();
						System.out.println();
						
						System.out.println("Prenom de client principal : ");
						String prenom = reader.readLine();
						System.out.println();
						
							// carte credit
						System.out.println("Numéro de Carte de Crédit (16 chiffres) : ");
						String carteNumero = reader.readLine();
						System.out.println();
						
						System.out.println("Mois expirée (2 chiffres) : ");
						inputStringToInt = new StringToInt(reader);
						int expireMois = (int) inputStringToInt.process();
						System.out.println();
						
						System.out.println("Année expirée (4 chiffres) : ");
						inputStringToInt = new StringToInt(reader);
						int expireAnnee = (int) inputStringToInt.process();
						System.out.println();
						
						System.out.println("CVC code (3 chiffres) : ");
						String cvcCode = reader.readLine();
						System.out.println();
						
						CarteCredit carteCredit = new CarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
						Client client = new Client(nom, prenom, carteCredit);
						
						Hotel hotelChoisi = hotelChambreChoisi.keySet().stream().findFirst().get();
						ArrayList<Chambre> chambreChoisi = hotelChambreChoisi.get(hotelChoisi);
						double prix = hotelChoisi.prixChambresPropose(chambreChoisi)*days;

						int reservationId = hotelChoisi.getReservCollection().size()+1;
						try {
							hotelChoisi.reserve(reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix);
							System.out.println("Votre réservation a été effectuée avec succès. Votre numéro de réservation est "+reservationId);
						} catch (Exception e) {
							System.err.println("Désolé, il y a eu un problème avec la réservation. essaie une autre fois.");
						}
					}
					break;
				case QUIT:
					System.out.println("Au revoir ...");
					return;
				default:
					System.err.println("Désolé, mauvaise entrée. essaie une autre fois.");
					return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void displayHotel(Hotel hotel) {
		System.out.println("ID: "+hotel.getHotelId()+ 
				", Nom de l'Hotel: "+hotel.getNom());
	}
	
	private static void displayPropose(HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose, int days) {
		for (Hotel hotel : hotelChambrePropose.keySet()) {
			String descLit = "";
			int nombreLits = 0;
			for (Chambre c : hotelChambrePropose.get(hotel)) {
//				System.err.println(c.toString());
				for (Lit lit : c.getLitCollection()) {
					descLit = descLit + lit.toString() + "\n";
					nombreLits++;
				}
			}
			System.out.println(
					"Nom de l'Hotel : " + hotel.getNom() + "\n" +
					"Catégorie : " + hotel.getCategorie() + " étoiles" + "\n" +
					"Adresse de l'hôtel : " + hotel.getAdresse().toString() + "\n" +
					"Prix ​​total pour le paiement : " + hotel.prixChambresPropose(hotelChambrePropose.get(hotel))*days + " (Pour " + days + " nuits)" + "\n" +
					"Nombre de lits fournis : " + nombreLits + "\n" + 
					descLit
			);
		}
	}
	
	private static int daysBetween(Calendar dateArrivee, Calendar dateDepart) {
		Date d1 = dateArrivee.getTime();
		Date d2 = dateDepart.getTime();
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	private static HashMap<Hotel, ArrayList<Chambre>> getPropose(String nomHotel, HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose) {
		HashMap<Hotel, ArrayList<Chambre>> hotelChambreChoisi = new HashMap<Hotel, ArrayList<Chambre>>();
		for (Hotel hotel : hotelChambrePropose.keySet()) {
			if (hotel.getNom().equals(nomHotel)) {
				hotelChambreChoisi.put(hotel, hotelChambrePropose.get(hotel));
			}
		}
		return hotelChambreChoisi;
	}
}
