package fr.gtm.biblio.inventaire.dao;




import javax.persistence.EntityManager;
import fr.gtm.biblio.inventaire.modele.Entite;


public interface EntiteDao<T> {
	
	EntityManager getEntityManager() ;
	

	/**
	 * Ajouter une nouvelle entité
	 * 
	 * @param entite
	 */

	void creer(Entite<T> entite);
	
	/**
	 * mettre à jour la nouvelle entite
	 * @param enite
	 */
	
	void modifier(Entite<T> entite);
	
	/**
	 * supprimer l'entité
	 * 
	 * @param id
	 */
	
	void supprimer(T id);
	
	/**
	 * chercher l'entite par id
	 * @param id
	 * @return
	 */
	Entite<T> chercherParId(T id);
	

}