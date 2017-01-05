package fr.gtm.biblio.inventaire.dao.tests;

import static org.junit.Assert.*;

import java.util.List;


import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.biblio.inventaire.dao.ExemplaireDao;
import fr.gtm.biblio.inventaire.dao.jpa.ExemplaireDaoImpl;
import fr.gtm.biblio.inventaire.modele.EtatExemplaire;
import fr.gtm.biblio.inventaire.modele.Exemplaire;

public class ExemplaireWithCdiDaoTestCase {
	private static Logger logger = Logger.getLogger(ExemplaireWithCdiDaoTestCase.class) ;
	private static ExemplaireDao exemplaireDao;
	private static Exemplaire exemplaire;
	private static String reference;
	private static EtatExemplaire etat;
	private static int nombreExemplaire;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("Init des ressources");
		logger.info("Init du conteneur Weld pour l'injection des dépendances");
		WeldContainer weld = new Weld().initialize();
		logger.info("injection ExemplaireDaoImpl ");
		exemplaireDao = weld.instance().select(ExemplaireDaoImpl.class).get();
		reference = "ref4";
		etat = EtatExemplaire.Disponible;
		exemplaire = new Exemplaire(reference,etat );
		nombreExemplaire = 0;
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("Init des ressources");
		exemplaireDao = null;
	}


	//@Test
	public void test1Creer() {
		logger.info("test1Creer");
		exemplaireDao.creer(exemplaire);
		List<Exemplaire> liste = exemplaireDao.chercherList(0,10);
		assertNotNull(liste);
		assertNotEquals(liste.size(),0);
		assertEquals(nombreExemplaire + 1 ,liste.size());
	}

	

}
