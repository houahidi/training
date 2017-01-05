/**
 * 
 */
package fr.gtm.biblio.inventaire.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.gtm.biblio.inventaire.cdi.interceptors.Transaction;
import fr.gtm.biblio.inventaire.dao.ExemplaireDao;
import fr.gtm.biblio.inventaire.modele.Entite;
import fr.gtm.biblio.inventaire.modele.Exemplaire;

/**
 * @author Adminl
 *
 */

public class ExemplaireDaoImpl extends EntiteDaoImpl<String> implements ExemplaireDao{ 

	public ExemplaireDaoImpl() {
		super();
	}
	
	public ExemplaireDaoImpl(EntityManager em) {
		super(em);
	}






	/* (non-Javadoc)
	 * @see fr.gtm.biblio.inventaire.dao.ExemplaireDao#chercherList(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exemplaire> chercherList(int index, int nombre) {
		Query query = em.createQuery("select e from Exemplaire e");
		query.setFirstResult(index);
		query.setMaxResults(nombre);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see fr.gtm.biblio.inventaire.dao.ExemplaireDao#chercherReference(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exemplaire> chercherReference(String reference) {
		Query query = em.createQuery("select e from Exemplaire e where e.reference like :reference");
		query.setParameter("reference", "%"+reference+"%");
		return query.getResultList();
	}

	@Override
	public Entite<String> chercherParId(String id) {
		
		return em.find(Exemplaire.class,id);
	}

}
