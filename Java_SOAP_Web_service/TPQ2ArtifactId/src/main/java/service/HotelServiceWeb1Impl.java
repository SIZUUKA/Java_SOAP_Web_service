package service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import model.Agence;
import model.HotelPartenaireTarif;
import model.Lit;
import model.Propose;
import repository.IRepoPlateforme;
import repository.RepoPlateformeImpl;

@WebService(endpointInterface="service.IHotelServiceWeb1")
@MTOM(threshold=10)
public class HotelServiceWeb1Impl implements IHotelServiceWeb1 {
	/* ATTRIBUTES */
	private IRepoPlateforme repoPlateformeImpl = new RepoPlateformeImpl();

	/* METHODS */
	@Override
	public Agence agenceLogin(String identifiant, String mdp) {
		return repoPlateformeImpl.agenceLogin(identifiant, mdp);
	}
	
	@Override
	public String getAgenceIdentifiant(Agence agenceLogin) {
		return repoPlateformeImpl.getAgenceIdentifiant(agenceLogin);
	}
	
	@Override
	public List<Propose> getAllCombinations(Agence agenceLogin,
			Calendar dateArrivee, Calendar dateDepart, int nombrePerson) {
		return repoPlateformeImpl.getAllCombinations(agenceLogin, dateArrivee, dateDepart, nombrePerson);
	}
	
	@Override
	public double prixChoisi(Propose propose, Agence agenceLogin, int days) {
		return repoPlateformeImpl.prixChoisi(propose, agenceLogin, days);
	}
	
	@Override
	public String getHotelNom(Propose propose) {
		return repoPlateformeImpl.getHotelNom(propose);
	}
	
	@Override
	public Image downloadImage(String imageName) {
        File image = new File("src/main/java/repository/images/"+imageName+".jpg");
        try {
            return ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public List<HotelPartenaireTarif> getAgencePartenaire(Agence agenceLogin) {
		return repoPlateformeImpl.getAgencePartenaire(agenceLogin);
	}
	
	@Override
	public String desc(Lit lit) {
		return repoPlateformeImpl.getLitDesc(lit);
	}
	
//	@Override
//	public List<String> getTest(Calendar cal1, Calendar cal2) {
//		return repoPlateformeImpl.getTest(cal1, cal2);
//	}

}
