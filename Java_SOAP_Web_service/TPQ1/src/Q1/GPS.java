package Q1;

public class GPS {
	private double latitude;
	private double longitude;
	
	public GPS(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "GPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
