package fr.gtm.biblio.inventaire.dao.jpa;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;



@ApplicationScoped
@Alternative
public class MainJPAApplication {

	private static Logger logger = Logger.getLogger(MainJPAApplication.class);
	@PersistenceUnit(unitName="InventairePU")
	private EntityManagerFactory emf;

	public MainJPAApplication() {
		logger.info("Initialisation MainJPAApplication");
	}
	
	@Produces
	public  EntityManager init(){
		/*if(emf == null){
			logger.info(">>>>>>>>>>> Initialisation de l'unite de persistance InventairePUTest");
			emf =  Persistence.createEntityManagerFactory("InventairePU");
		}*/
			
		logger.info(">>>>>>>>>>> creation de l'EntityManager");
		return emf.createEntityManager();
	}

	
	public void closeEntityManager(@Disposes EntityManager entityManager)
    {
		logger.info(">>>>>>>>>>> Clôture de l'EntityManager");
        if (entityManager.isOpen())
        {
            entityManager.close();
        }
    }
    

}
