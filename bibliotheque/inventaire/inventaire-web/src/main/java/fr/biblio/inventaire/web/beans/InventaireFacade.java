package fr.biblio.inventaire.web.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import fr.gtm.biblio.inventaire.dao.ExemplaireDao;
import fr.gtm.biblio.inventaire.modele.Exemplaire;


@Named("facade")
@RequestScoped
public class InventaireFacade {
	private static Logger logger = Logger.getLogger(InventaireFacade.class) ;
	@Inject
	private ExemplaireDao exemplaireDao;
	
	public InventaireFacade() {
		logger.info("constructeur");
	}

	public List<Exemplaire> getExemplaires(){
		logger.info("Récuperer la liste");
		return exemplaireDao.chercherList(0, 10);
	}

}
