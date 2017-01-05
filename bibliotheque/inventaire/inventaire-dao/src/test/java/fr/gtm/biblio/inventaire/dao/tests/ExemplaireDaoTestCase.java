package fr.gtm.biblio.inventaire.dao.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.biblio.inventaire.dao.ExemplaireDao;
import fr.gtm.biblio.inventaire.dao.jpa.ExemplaireDaoImpl;
import fr.gtm.biblio.inventaire.modele.EtatExemplaire;
import fr.gtm.biblio.inventaire.modele.Exemplaire;

public class ExemplaireDaoTestCase {
	private static Logger logger = Logger.getLogger(ExemplaireDaoTestCase.class) ;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static ExemplaireDao exemplaireDao;
	private static Exemplaire exemplaire;
	private static String reference;
	private static EtatExemplaire etat;
	private static int nombreExemplaire;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("Init des ressources");
		emf = Persistence.createEntityManagerFactory("InventairePUTest");
		em = emf.createEntityManager();
		exemplaireDao = new ExemplaireDaoImpl(em);
		reference = "ref1";
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
	}

	

}
