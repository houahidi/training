package fr.carsat.service.soap.rpc;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;


@WebService(name="CalculatriceContrat")
@SOAPBinding(style=Style.RPC, use=Use.LITERAL)

public interface CalculatriceService {
	
	@WebMethod(operationName="Addition",action="urn:add")
	@WebResult(name="Resultat") double additionner(@WebParam(name="Operande1",partName="Operande1Part") double op1, 
													@WebParam(name="Operande2", partName="Operande2Part") double op2);
	
	@WebMethod(operationName="Division",action="urn:div")
	@WebResult(name="Resultat") double diviser(@WebParam(name="Operande1",partName="Operande1Part") double op1, 
												@WebParam(name="Operande2",partName="Operande2Part") double op2);
	
	@WebMethod(operationName="Multiplication",action="urn:mul")
	@WebResult(name="Resultat") double multiplier(@WebParam(name="Operande1",partName="Operande1Part") double op1, 
													@WebParam(name="Operande2",partName="Operande2Part") double op2);
	
	@WebMethod(operationName="Soustraction",action="urn:min")
	@WebResult(name="Resultat") double soustraire(@WebParam(name="Operande1",partName="Operande1Part") double op1, 
					  								@WebParam(name="Operande2",partName="Operande2Part") double op2);
	
	@WebMethod(operationName="Notification",action="urn:notify")
	@Oneway
	void notifier(@WebParam(name="message") String message) ;
}
