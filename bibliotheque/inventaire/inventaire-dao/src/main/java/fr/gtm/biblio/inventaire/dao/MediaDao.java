package fr.gtm.biblio.inventaire.dao;

import java.util.List;

import fr.gtm.biblio.inventaire.modele.Media;

public interface MediaDao  extends EntiteDao<Long>{
	
	List<Media> chercherList(int index, int nombre);
	Media chercherAvecExemplaires(Long id);

}
