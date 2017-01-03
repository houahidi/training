package fr.carsat.service.deploiement;

import javax.xml.ws.Endpoint;

import fr.carsat.service.soap.rpc.CalculatriceServiceImpl;

public class CalculatricePublicationRPC {

	public static void main(String[] args) {
		
		System.out.println("Publication du web service en tant que Application Java autonome");
		String url = "http://localhost:9001/CalculatriceServiceRPC";
		System.out.println("Url : "+url);
		//Instanciation du service
		CalculatriceServiceImpl service = new CalculatriceServiceImpl();
		//Publication
		Endpoint.publish(url,service);

	}

}
