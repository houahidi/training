package fr.gtm.biblio.inventaire.dao.jpa;



import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;




@Alternative
public class TestJPAApplication {

	private static Logger logger = Logger.getLogger(TestJPAApplication.class);
	
	private static EntityManagerFactory emf;

	public TestJPAApplication() {
		logger.info("Initialisation TestJPAApplication");
	}
	
	
	
	@Produces
	public static EntityManager init(){
		if(emf == null){
			logger.info(">>>>>>>>>>> Initialisation de l'unite de persistance InventairePUTest");
			emf =  Persistence.createEntityManagerFactory("InventairePUTest");
		}
			
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
