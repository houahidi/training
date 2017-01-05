package fr.biblio.inventaire.web.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@RequestScoped
public class HelloBean  {

	private Logger logger = Logger.getLogger(HelloBean.class);
	
	private String name;
	
	public HelloBean() {
		logger.info("Constructeur");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	@PostConstruct
	public void init(){
		this.name  = "hafid";
	}
	

	
}
