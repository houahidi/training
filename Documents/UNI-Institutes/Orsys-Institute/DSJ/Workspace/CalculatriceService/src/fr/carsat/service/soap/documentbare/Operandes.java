package fr.carsat.service.soap.documentbare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Operandes")
@XmlType(name="OperandesType", propOrder={"operande1","operande2"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Operandes {
	
	@XmlElement(name="Op1")
	private double operande1;
	@XmlElement(name="Op2")
	private double operande2;
	
	public Operandes() {
	}

	public Operandes(double operande1, double operande2) {
		super();
		this.operande1 = operande1;
		this.operande2 = operande2;
	}

	public double getOperande1() {
		return operande1;
	}

	public void setOperande1(double operande1) {
		this.operande1 = operande1;
	}

	public double getOperande2() {
		return operande2;
	}

	public void setOperande2(double operande2) {
		this.operande2 = operande2;
	}
	
	
	

}
