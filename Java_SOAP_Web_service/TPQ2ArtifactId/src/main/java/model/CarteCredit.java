package model;

import java.util.Calendar;

public class CarteCredit {
	private String carteNumero;
	private String cvcCode;
	private int expireMois; // 2 chiffres
	private int expireAnnee; // 4 chiffres
	
	private Calendar current = Calendar.getInstance();

	public CarteCredit() {
		super();
	}

	public CarteCredit(String carteNumero, String cvcCode, int expireMois, int expireAnnee) {
		super();
		this.setCarteNumero(carteNumero);
		this.setCvcCode(cvcCode);
		if(this.carteValide(expireMois, expireAnnee)) {
			this.setExpireMois(expireMois);
			this.setExpireAnnee(expireAnnee);
		} else {
			System.out.println("Carte invalidee !");
		}
	}

	public String getCarteNumero() {
		return carteNumero;
	}

	public void setCarteNumero(String carteNumero) {
		if (carteNumero.length() == 16) {
			this.carteNumero = carteNumero;
		} else {
			System.out.println("faux carte numero!");
		}
	}

	public String getCvcCode() {
		return cvcCode;
	}

	public void setCvcCode(String cvcCode) {
		if (cvcCode.length() == 3) {
			this.cvcCode = cvcCode;
		} else {
			System.out.println("faux CVC code!");
		}
	}

	public int getExpireMois() {
		return expireMois;
	}

	public void setExpireMois(int expireMois) {
		this.expireMois = expireMois;
	}

	public int getExpireAnnee() {
		return expireAnnee;
	}

	public void setExpireAnnee(int expireAnnee) {
		this.expireAnnee = expireAnnee;
	}
	
	public boolean carteValide(int mois, int annee) {
		Calendar dateExpiree = Calendar.getInstance();
		dateExpiree.set(annee, mois-1, 1);
		return dateExpiree.after(current);
	}
	
}
