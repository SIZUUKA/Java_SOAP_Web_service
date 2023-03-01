package Q1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public interface IHotelRepo {
	
	int count();
	
	List<Hotel> getHotelCollection();
	
	Hotel getHotel(int id);
	
	HashMap<Hotel, ArrayList<Chambre>> hotelChambrePropose(String ville, Calendar dateArrivee, Calendar dateDepart, 
			double min, double max, int categorie, int nombrePerson);
}
