package fr.gtm.biblio.inventaire.modele;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Exemplaire  implements Entite<String>{
	
	@Id
	private String reference;
	@Enumerated(EnumType.STRING)
	private EtatExemplaire etat;
	
	public Exemplaire() {
		this.etat = EtatExemplaire.Disponible;
	}
	
	

	public Exemplaire(String reference, EtatExemplaire etat) {
		this();
		this.reference = reference;
		this.etat = etat;
	}



	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the etat
	 */
	public EtatExemplaire getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatExemplaire etat) {
		this.etat = etat;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Exemplaire))
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}



	@Override
	public String getId() {
		
		return reference;
	}



	@Override
	public void setId(String t) {
		this.reference = t;
		
	}
	
	

}
