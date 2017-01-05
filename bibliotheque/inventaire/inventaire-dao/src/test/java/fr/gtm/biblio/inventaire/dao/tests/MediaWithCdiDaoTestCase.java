package fr.gtm.biblio.inventaire.dao.tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.biblio.inventaire.dao.MediaDao;
import fr.gtm.biblio.inventaire.dao.jpa.MediaDaoImpl;
import fr.gtm.biblio.inventaire.modele.EtatExemplaire;
import fr.gtm.biblio.inventaire.modele.Exemplaire;
import fr.gtm.biblio.inventaire.modele.Media;

public class MediaWithCdiDaoTestCase {
	private static Logger logger = Logger.getLogger(MediaWithCdiDaoTestCase.class) ;
	private static MediaDao mediaDao;
	private static Media media;
	private static Long id;
	private static Date datePublication;
	private static String titre;
	private static int nombreMedias;
	private static int nombreExemplaires;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.info("Init des ressources");
		logger.info("Init du conteneur Weld pour l'injection des dépendances");
		WeldContainer weld = new Weld().initialize();
		logger.info("injection MediaDaoImpl ");
		mediaDao = weld.instance().select(MediaDaoImpl.class).get();
		id = null;
		
		media = new Media(id,titre,datePublication );
		nombreMedias = 0;
		nombreExemplaires = 0;
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.info("Init des ressources");
		mediaDao = null;
	}

	
	@Test
	public void test1Creer() {
		logger.info("test1Creer");
		media.addExemplaire(new Exemplaire("ref1",EtatExemplaire.Disponible));
		media.addExemplaire(new Exemplaire("ref2",EtatExemplaire.Disponible));
		mediaDao.creer(media);
		List<Media> liste = mediaDao.chercherList(0,10);
		assertNotNull(liste);
		assertNotEquals(liste.size(),0);
		assertEquals(nombreMedias + 1 ,liste.size());
		Media m = mediaDao.chercherAvecExemplaires(media.getId());
		assertNotNull(m);
		assertNotNull(m.getExemplaires());
		assertEquals(nombreExemplaires + 2 ,m.getExemplaires().size());
	}


}
