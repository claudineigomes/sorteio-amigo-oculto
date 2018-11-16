package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Participante {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstname;

    private String email;

	private String foiretirado;

	private String jaretirou;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoiretirado() {
		return foiretirado;
	}

	public void setFoiretirado(String foiretirado) {
		this.foiretirado = foiretirado;
	}

	public String getJaretirou() {
		return jaretirou;
	}

	public void setJaretirou(String jaretirou) {
		this.jaretirou = jaretirou;
	}
}

