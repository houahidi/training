package fr.gtm.biblio.inventaire.dao;
import java.util.Date;

class Test {

	private String name;
	
	private long id;

	private long version;
	
	private String author;
	
	private Date publishedAt;
	

	public Test() {

	}
	
	

	public Test(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

}
