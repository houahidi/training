package fr.carsat.service.soap.documentbare;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(name="CalculatriceContrat")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)

public interface CalculatriceService {

	@WebMethod(operationName="Addition",action="urn:add")
	@WebResult(name="Resultat") double additionner(@WebParam(name="LesOperandes") Operandes operandes);
	
	@RequestWrapper(localName="RequeteNotification")
	@WebMethod(operationName="Notification",action="urn:notify")
	@Oneway
	void notifier(@WebParam(name="message") String message) ;
}
