package fr.gtm.biblio.inventaire.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_medias")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type",length=1)
@DiscriminatorValue("M")
public class Media implements Entite<Long>  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date datePublication;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="media_id")
	private List<Exemplaire> exemplaires;
	
	public Media() {
		exemplaires = new ArrayList<Exemplaire>();
	}
	

	public Media(Long id, String name, Date datePublication) {
		this();
		this.id = id;
		this.name = name;
		this.datePublication = datePublication;
	}


	public void addExemplaire(Exemplaire e){
		if(!exemplaires.contains(e)){
			exemplaires.add(e);
		}
	}
	
	public void removeExemplaire(Exemplaire e){
		if(exemplaires.contains(e)){
			exemplaires.remove(e);
		}
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the datePublication
	 */
	public Date getDatePublication() {
		return datePublication;
	}



	/**
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long t) {
		this.id = t;
		
	}
	
	

	/**
	 * @return the exemplaires
	 */
	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	/**
	 * @param exemplaires the exemplaires to set
	 */
	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Media))
			return false;
		Media other = (Media) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
