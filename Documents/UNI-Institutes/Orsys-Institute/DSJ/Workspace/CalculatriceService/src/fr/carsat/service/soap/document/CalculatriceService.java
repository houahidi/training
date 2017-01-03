package fr.carsat.service.soap.document;

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
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)

public interface CalculatriceService {
	
	@RequestWrapper(localName="RequeteAddition")
	@ResponseWrapper(localName="ReponseAddition")
	@WebMethod(operationName="Addition",action="urn:add")
	@WebResult(name="Resultat") double additionner(@WebParam(name="Operande1") double op1, 
													@WebParam(name="Operande2") double op2);
	
	@RequestWrapper(localName="RequeteDivision")
	@ResponseWrapper(localName="ReponseDivision")
	@WebMethod(operationName="Division",action="urn:div")
	@WebResult(name="Resultat") double diviser(@WebParam(name="Operande1") double op1, 
												@WebParam(name="Operande2") double op2);
	
	@RequestWrapper(localName="RequeteMultiplication")
	@ResponseWrapper(localName="ReponseMultiplication")
	@WebMethod(operationName="Multiplication",action="urn:mul")
	@WebResult(name="Resultat") double multiplier(@WebParam(name="Operande1") double op1, 
													@WebParam(name="Operande2") double op2);
	
	@RequestWrapper(localName="RequeteSoustraction")
	@ResponseWrapper(localName="ReponseSoustraction")
	@WebMethod(operationName="Soustraction",action="urn:min")
	@WebResult(name="Resultat") double soustraire(@WebParam(name="Operande1") double op1, 
					  								@WebParam(name="Operande2") double op2);
	
	@RequestWrapper(localName="RequeteNotification")
	@WebMethod(operationName="Notification",action="urn:notify")
	@Oneway
	void notifier(@WebParam(name="message") String message) ;
}
