package fr.gtm.biblio.inventaire.dao.jpa;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import fr.gtm.biblio.inventaire.cdi.interceptors.Transaction;
import fr.gtm.biblio.inventaire.dao.EntiteDao;
import fr.gtm.biblio.inventaire.modele.Entite;




public abstract class EntiteDaoImpl<T> implements EntiteDao<T>{
	
	@Inject
	protected EntityManager em;
	
	private static Logger logger = Logger.getLogger(EntiteDaoImpl.class);
	
	public EntiteDaoImpl() {
		
	}
		
	public EntiteDaoImpl(EntityManager em) {
		this();
		this.em = em;
	}

	public EntityManager getEntityManager() {
		return em;
	}
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	
	@Override
	@Transaction
	
	public void creer(Entite<T> entite) {
		logger.info("sauvegarder l'entite " + entite.getId());
		//em.getTransaction().begin();
		em.persist(entite);
		//em.getTransaction().commit();

	}

	@Override
	@Transaction
	public void modifier(Entite<T> entite) {
		logger.info("mettre à jour la l'entite " + entite.getId());
		//em.getTransaction().begin();
		em.merge(entite);
		//em.getTransaction().commit();

	} 

	@Override
	@Transaction
	public void supprimer(T id) {
		logger.info("supprimer l'entité "+ id);
		Entite<T> c = chercherParId(id);
		//em.getTransaction().begin();
		em.remove(c);
		//em.getTransaction().commit();
		
	}

}
