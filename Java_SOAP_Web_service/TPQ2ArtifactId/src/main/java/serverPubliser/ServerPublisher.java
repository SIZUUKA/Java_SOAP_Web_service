package serverPubliser;

import javax.xml.ws.Endpoint;

import service.HotelServiceWeb1Impl;
import service.HotelServiceWeb2Impl;

public class ServerPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/serviceweb1", new HotelServiceWeb1Impl());
		System.err.println("Server web 1 ready");
		
		Endpoint.publish("http://localhost:8080/serviceweb2", new HotelServiceWeb2Impl());
		System.err.println("Server web 2 ready");
	}

}
