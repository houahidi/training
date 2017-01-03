/**
 * 
 */
package fr.carsat.service.soap.documentbare;

import javax.jws.WebService;

/**
 * @author houahidi
 *
 */

@WebService(serviceName="CalculatriceService",portName="CalculatriceServicePort",
			endpointInterface="fr.carsat.service.soap.documentbare.CalculatriceService")
public class CalculatriceServiceImpl implements CalculatriceService {

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#additionner(Operandes)
	 */
	@Override
	public double additionner(Operandes operandes) {
		
		double op1 = operandes.getOperande1();
		double op2 = operandes.getOperande2();
		System.out.println(String.format("additioner(%s,%s)", op1,op2));
		return op1 + op2;
	}

	

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#notifier(java.lang.String)
	 */
	@Override
	public void notifier(String message)  {
		System.out.println(String.format("notifier(message : %s)", message));
		
	}

}
