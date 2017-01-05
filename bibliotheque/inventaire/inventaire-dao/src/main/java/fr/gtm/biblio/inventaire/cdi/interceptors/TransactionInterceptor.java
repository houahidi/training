package fr.gtm.biblio.inventaire.cdi.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import fr.gtm.biblio.inventaire.dao.EntiteDao;

@Interceptor
@Transaction
public class TransactionInterceptor {

	public Logger logger = Logger.getLogger(TransactionInterceptor.class);
	
	public TransactionInterceptor() {
		logger.info("initialisation de l'intercepteur");
	}
	
	
	@AroundInvoke
	public Object txManagement(InvocationContext context){
		EntiteDao entiteDao = (EntiteDao) context.getTarget();
		try {
			logger.info("###### transaction begin");
			
			entiteDao.getEntityManager().getTransaction().begin();
			Object object =  context.proceed();
			logger.info("###### transaction commit");
			entiteDao.getEntityManager().getTransaction().commit();
			return object;
		} catch (Exception e) {
			logger.error(e.getMessage());
			entiteDao.getEntityManager().getTransaction().rollback();
			return null;
		}
		
		
	}
}
