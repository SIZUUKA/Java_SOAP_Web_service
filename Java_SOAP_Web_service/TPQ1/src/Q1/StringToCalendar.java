package Q1;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Predicate;

public class StringToCalendar {
	private BufferedReader inputReader;
	private String message;
	private Predicate<String> isValid;
	
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
	public StringToCalendar(BufferedReader inputReader) {
		this.inputReader = inputReader;
		setMessage();
		setValidityCriterion();
	}

	public void setMessage() {
		message = "Veuillez saisir date en format dd/MM/yyyy :";		
	}

	public void setValidityCriterion() {
		isValid = str -> {
		try { 
			Date date = sdf.parse((String) str);
				return date instanceof Date;
		    } catch (Exception e) {
		    	return false;
		    }
		};
	}
	
	public Calendar process() {
		try {
//			System.out.println(message);
			String userInput = inputReader.readLine();

			while (!isValid.test(userInput)) {
				System.err.println("D?sol?, mauvaise entr?e. essaie une autre fois.");
				System.out.println();
				System.out.println(message);
				userInput = inputReader.readLine();
			}
			
			Date date = sdf.parse(userInput);
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        return cal;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
