/**
 * 
 */
package fr.carsat.service.soap.rpc;

import javax.jws.WebService;

/**
 * @author houahidi
 *
 */

@WebService(serviceName="CalculatriceService",portName="CalculatriceServicePort",
			endpointInterface="fr.carsat.service.soap.rpc.CalculatriceService")
public class CalculatriceServiceImpl implements CalculatriceService {

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#additionner(double, double)
	 */
	@Override
	public double additionner(double op1, double op2) {
		System.out.println(String.format("additioner(%s,%s)", op1,op2));
		return op1 + op2;
	}

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#diviser(double, double)
	 */
	@Override
	public double diviser(double op1, double op2) {
		System.out.println(String.format("diviser(%s,%s)", op1,op2));
		return op1 / op2;
	}

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#multiplier(double, double)
	 */
	@Override
	public double multiplier(double op1, double op2) {
		System.out.println(String.format("multiplier(%s,%s)", op1,op2));
		return op1 * op2;
	}

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#soustraire(double, double)
	 */
	@Override
	public double soustraire(double op1, double op2) {
		System.out.println(String.format("soustraire(%s,%s)", op1,op2));
		return op1 - op2;
	}

	/* (non-Javadoc)
	 * @see fr.carsat.service.soap.CalculatriceService#notifier(java.lang.String)
	 */
	@Override
	public void notifier(String message)  {
		System.out.println(String.format("notifier(message : %s)", message));
		
	}

}
