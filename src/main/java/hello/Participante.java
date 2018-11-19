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

	private String senha;

	private String quemtirou;

	private String jaconsultou;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getQuemtirou() {
		return quemtirou;
	}

	public void setQuemtirou(String quemtirou) {
		this.quemtirou = quemtirou;
	}

	public String getJaconsultou() {
		return jaconsultou;
	}

	public void setJaconsultou(String jaconsultou) {
		this.jaconsultou = jaconsultou;
	}
}

