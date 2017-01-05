/**
 * 
 */
package fr.gtm.biblio.inventaire.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.gtm.biblio.inventaire.dao.MediaDao;
import fr.gtm.biblio.inventaire.modele.Entite;
import fr.gtm.biblio.inventaire.modele.Media;

/**
 * @author Adminl
 *
 */
public class MediaDaoImpl extends EntiteDaoImpl<Long> implements MediaDao{ 

	public MediaDaoImpl() {
		super();
	}
	
	public MediaDaoImpl(EntityManager em) {
		super(em);
	}

	/* (non-Javadoc)
	 * @see fr.gtm.biblio.inventaire.dao.MediaDao#chercherList(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Media> chercherList(int index, int nombre) {
		Query query = em.createQuery("select m from Media m");
		query.setFirstResult(index);
		query.setMaxResults(nombre);
		return query.getResultList();
	}


	@Override
	public Entite<Long> chercherParId(Long id) {
		
		return em.find(Media.class,id);
	}

	@Override
	public Media chercherAvecExemplaires(Long id) {
		Query query = em.createQuery("select m from Media m join fetch m.exemplaires where m.id =:id");
		query.setParameter("id",id);
		 return (Media) query.getSingleResult();
	}

}
