package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import service1.Chambre;
import service1.Client;
import service1.Lit;
import service1.HotelPartenaireTarif;
import service1.Propose;
import service1.Reservation;
import service1.Agence;
import service1.IHotelServiceWeb1;
import service2.CarteCredit;
import service2.IHotelServiceWeb2;

public class HotelServiceClientCLI {
	public static final String QUIT = "0";
	public static StringToCalendar inputStringToCalendar;
	public static StringToDouble inputStringToDouble;
	public static StringToInt inputStringToInt;
	
	public static void main(String[] args) throws MalformedURLException {
		URL url1 = new URL("http://localhost:8080/serviceweb1?wsdl");
		URL url2 = new URL("http://localhost:8080/serviceweb2?wsdl");
		
		service1.HotelServiceWeb1ImplService hotelServiceWeb1Impl = new service1.HotelServiceWeb1ImplService(url1);
		service1.IHotelServiceWeb1 proxy1 = hotelServiceWeb1Impl.getHotelServiceWeb1ImplPort();
		
		service2.HotelServiceWeb2ImplService hotelServiceWeb2Impl = new service2.HotelServiceWeb2ImplService(url2);
		service2.IHotelServiceWeb2 proxy2 = hotelServiceWeb2Impl.getHotelServiceWeb2ImplPort();
		
		HotelServiceClientCLI main = new HotelServiceClientCLI();
		BufferedReader inputReader;
		String userInput = "";
		
		inputReader = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader, userInput, proxy1, proxy2);
				Thread.sleep(1000);
			} while(!userInput.equals(QUIT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Agence Login :");
		System.out.println(builder);
	}

	private void processUserInput(BufferedReader reader, String userInput, IHotelServiceWeb1 proxy1, IHotelServiceWeb2 proxy2) {
		try {
			switch(userInput) {
				default:
					System.err.println("Désolé, mauvaise saisie. Veuillez réessayer.");
					return;
				case QUIT:
					System.out.println("Au revoir ...");
					return;
				case "1":
					Agence agenceLogin = this.login(reader, proxy1);
					while (agenceLogin == null) {
						System.err.println("Identifiant ou mot de passe n'est pas correct, veuillez réessayer !\n");
						agenceLogin = this.login(reader, proxy1);
					}
					System.out.println(proxy1.getAgenceIdentifiant(agenceLogin)+" login avec succès !");

//					List<HotelPartenaireTarif> p =  proxy1.getAgencePartenaire(agenceLogin);
//					for (HotelPartenaireTarif hp : p) {
//						System.out.println("partenaire : "+hp.getPourcentage());
//					}
					
					System.out.println("Date arrivée (dd/MM/yyyy) aujourd'hui ou après aujourd'hui : ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateArrivee = (Calendar) inputStringToCalendar.process();
					System.out.println();
					
					System.out.println("Date départ (dd/MM/yyyy) après date arrivée : ");
					inputStringToCalendar = new StringToCalendar(reader);
					Calendar dateDepart = (Calendar) inputStringToCalendar.process();
					while (!dateDepart.after(dateArrivee)) {
						System.err.println("Date départ doit être après date arrivée !");
						System.out.println();
						System.out.println("Date départ (dd/MM/yyyy): ");
						inputStringToCalendar = new StringToCalendar(reader);
						dateDepart = (Calendar) inputStringToCalendar.process();
					}
					System.out.println();
							
					System.out.println("Nombre de personnes à héberger: ");
					inputStringToInt = new StringToInt(reader);
					int nombrePerson = (int) inputStringToInt.process();
					System.out.println();
					
					List<Propose> allCombinations = 
							proxy1.getAllCombinations(agenceLogin, this.calendarToXMLGregorianCalendar(dateArrivee), this.calendarToXMLGregorianCalendar(dateDepart), nombrePerson);
					if (allCombinations.size() == 0) {
						System.err.println("Désolé, pas d'hôtel correspond. Veuillez réessayer.");
						break;
					} else {
						System.out.println("Voici tous les propositions : ");
						int days = this.daysBetween(dateArrivee, dateDepart);
						List<String> listChambreId = this.displayAllCombinations(allCombinations, dateArrivee, dateDepart, agenceLogin, days, proxy1);
						String display = "";
						do {
							System.out.println("Display image de chambre ? y/n");
							display = reader.readLine();
							System.out.println();
							this.processDisplayInput(reader, display, listChambreId, proxy1);
						} while(!display.equals("n"));
						
						// IHotelServiceWeb2 reserver
						System.out.println("Saisir l‘identifiant de l'offre pour réserver : ");
						String identifiantOffre = reader.readLine();
						System.out.println();
						Propose offreChoisi = this.getPropose(allCombinations, identifiantOffre);
						while (offreChoisi == null) {
							System.err.println("Désolé, pas d'hôtel correspond. Veuillez réessayer.");
							System.out.println("Saisir l‘identifiant de l'offre pour réserver : ");
							identifiantOffre = reader.readLine();
							System.out.println();
							offreChoisi = this.getPropose(allCombinations, identifiantOffre);
						}
						
						System.out.println(identifiantOffre+" est choisi.");
						// Agence login
						Agence agenceLoginRes = this.loginRes(reader, proxy2);
						while (agenceLoginRes == null || 
								!agenceLoginRes.getIdentifiant().equals(agenceLogin.getIdentifiant()) ||
								!agenceLoginRes.getMdp().equals(agenceLogin.getMdp())) {
							System.err.println("Identifiant ou mot de passe n'est pas correct, veuillez réessayer !\n");
							agenceLoginRes = this.loginRes(reader, proxy2);
						}
						System.out.println(proxy1.getAgenceIdentifiant(agenceLogin)+" login avec succès !");
						// Client
						System.out.println("Nom de client principal : ");
						String nom = reader.readLine();
						System.out.println();
						
						System.out.println("Prenom de client principal : ");
						String prenom = reader.readLine();
						System.out.println();
						
						// carte credit
						System.out.println("Numéro de carte crédit (16 chiffres) : ");
						String carteNumero = reader.readLine();
						System.out.println();
						
						System.out.println("Mois expiré (2 chiffres) : ");
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
						
						CarteCredit carteCredit = proxy2.createCarteCredit(carteNumero, cvcCode, expireMois, expireAnnee);
						Client client = proxy2.createClient(nom, prenom, carteCredit);
						
						HotelPartenaireTarif hotelPartenaireTarif = offreChoisi.getHotelPartenaireTarif();
						List<Chambre> chambreChoisi = offreChoisi.getListChambre();
						double prixChoisi = proxy1.prixChoisi(offreChoisi, agenceLogin, days);
						
						String reservationId = this.generateResId(agenceLoginRes, hotelPartenaireTarif, client);
						reservationId = reservationId.replaceAll("\\s+","");
						Reservation res = proxy2.createReservation(hotelPartenaireTarif, reservationId, chambreChoisi, this.calendarToXMLGregorianCalendar(dateArrivee), this.calendarToXMLGregorianCalendar(dateDepart), client, prixChoisi, agenceLoginRes);
						//hotelPartenaireTarif, reservationId, chambreChoisi, dateArrivee, dateDepart, client, prix, agence
						try {
							proxy2.reserve(hotelPartenaireTarif, res, agenceLoginRes);
							System.out.println("Réservé avec succès. Votre numéro de réservation est "+reservationId);
						} catch (Exception e) {
							System.err.println("Désolé, il y a un problème avec la réservation. Veuillez réessayer.");
							break;
						}
					}
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public List<String> displayAllCombinations(List<Propose> allCombinationsList, 
			Calendar dateArrivee, Calendar dateDepart, Agence agenceLogin, int days, IHotelServiceWeb1 proxy1) {
		List<String> listChambreId = new ArrayList<>();
		for (Propose propose : allCombinationsList) {
			System.out.println(
					"Identifiant de l'offre : " + propose.getOffreId() + "\n" +
					"Nom de l'hôtel : " + proxy1.getHotelNom(propose) + "\n" +
					"Date de disponibilité : de " + this.calendarToString(dateArrivee) + " à " + this.calendarToString(dateDepart)
			);
			int nombreLits = 0;
			for (Chambre c : propose.getListChambre()) {
				listChambreId.add(c.getChambreId());
				String descLit = "";
				System.out.println(
						"#Chambre Id : " + c.getChambreId()
				);
				for (Lit lit : c.getLitCollection()) {
					descLit = descLit + proxy1.desc(lit) + "\n";
					nombreLits++;
				}
				System.out.println(
					descLit
				);
			}
			System.out.println(
					"Nombre de lits totaux proposés : " + nombreLits + "\n" +
					"Prix total à payer : " + this.doubleToString(proxy1.prixChoisi(propose, agenceLogin, days)) + " (avec pourcentage de commission)" + " (Pour " + days + " nuits)" + "\n" +
					"--------------------"
			);
		}
		return listChambreId;
	}
	
	private String calendarToString(Calendar date) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format1.format(date.getTime());
        return dateString;
	}
	
	private String doubleToString(double prix) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(prix);
	}
		
	private int daysBetween(Calendar dateArrivee, Calendar dateDepart) {
		Date d1 = dateArrivee.getTime();
		Date d2 = dateDepart.getTime();
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	private Agence login(BufferedReader reader, IHotelServiceWeb1 proxy1) {
		String identifiant = null;
		String mdp = null;
		try {
			System.out.println("Veuillez login pour rechercher !");
			System.out.println("Saisir identifiant de l'agence :");
			
			identifiant = reader.readLine();
			System.out.println();
			
			System.out.println("Saisir mot de passe de l'agence :");
			mdp = reader.readLine();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return proxy1.agenceLogin(identifiant, mdp);
	}
	
	private Agence loginRes(BufferedReader reader, IHotelServiceWeb2 proxy2) {
		String identifiant = null;
		String mdp = null;
		try {
			System.out.println("Veuillez login pour reserver !");
			System.out.println("Saisir identifiant de l'agence (le même identifiant d'agence qui a récupéré les offres) :");
			identifiant = reader.readLine();
			System.out.println();
			
			System.out.println("Saisir mot de passe de l'agence :");
			mdp = reader.readLine();
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return proxy2.agenceLoginRes(identifiant, mdp);
	}
	
	private String generateResId(Agence agenceLoginRes, HotelPartenaireTarif hotelPartenaireTarif, Client client) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String reservationId = agenceLoginRes.getIdentifiant()+client.getNom()+timestamp.getTime();
		return reservationId;
	}
	
	private Propose getPropose(List<Propose> allCombinationsList, String identifiantOffre) {
		for (Propose propose : allCombinationsList) {
			if (propose.getOffreId().equals(identifiantOffre)) {
				return propose;
			}
		}
		return null;
	}
	
	public void displayImage(String imageName, IHotelServiceWeb1 proxy1) {
		byte[] image = proxy1.downloadImage(imageName);
		JFrame imageFrame = new JFrame();
        imageFrame.setSize(1024, 683);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageFrame.add(imageLabel);
        imageFrame.setVisible(true);
        imageFrame.setAlwaysOnTop(true);
    }
	
	public void processDisplayInput(BufferedReader reader, String display, List<String> listChambreId, IHotelServiceWeb1 proxy1) {
		try {
			switch(display) {
			default:
				System.err.println("Désolé, mauvaise saisie. Veuillez réessayer.");
				return;
			case "n":
				return;
			case "y":
				System.out.println("Chambre Id ?");
				String chambreId = reader.readLine();
				if (listChambreId.contains(chambreId)) {
					this.displayImage(chambreId, proxy1);
				} else {
					System.err.println("Chambre Id n'est pas correct.");
				}
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private XMLGregorianCalendar calendarToXMLGregorianCalendar(Calendar cal) {
		XMLGregorianCalendar gDateFormatted = null;
		try {
			gDateFormatted =
					DatatypeFactory.newInstance().newXMLGregorianCalendar(
						cal.get(Calendar.YEAR),
						cal.get(Calendar.MONTH) + 1,
						cal.get(Calendar.DAY_OF_MONTH),
						cal.get(Calendar.HOUR_OF_DAY),
						cal.get(Calendar.MINUTE),
						cal.get(Calendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return gDateFormatted;
	}
	
}