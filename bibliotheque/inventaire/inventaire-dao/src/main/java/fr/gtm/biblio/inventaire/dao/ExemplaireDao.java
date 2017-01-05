package fr.gtm.biblio.inventaire.dao;

import java.util.List;

import fr.gtm.biblio.inventaire.modele.Exemplaire;

public interface ExemplaireDao  extends EntiteDao<String>{
	
	List<Exemplaire> chercherList(int index, int nombre);
	List<Exemplaire> chercherReference(String reference);

}
