package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pacient database table.
 * 
 */
@Entity
@NamedQuery(name="Pacient.findAll", query="SELECT p FROM Pacient p")
public class Pacient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pacient")
	private int idPacient;

	@Column(name="boala_pacient")
	private String boalaPacient;

	@Column(name="nume_pacient")
	private String numePacient;

	@Column(name="tratament_pacient")
	private String tratamentPacient;

	@Column(name="varsta_pacient")
	private int varstaPacient;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="pacient")
	private List<Personal> personals;

	public Pacient() {
	}

	public int getIdPacient() {
		return this.idPacient;
	}

	public void setIdPacient(int idPacient) {
		this.idPacient = idPacient;
	}

	public String getBoalaPacient() {
		return this.boalaPacient;
	}

	public void setBoalaPacient(String boalaPacient) {
		this.boalaPacient = boalaPacient;
	}

	public String getNumePacient() {
		return this.numePacient;
	}

	public void setNumePacient(String numePacient) {
		this.numePacient = numePacient;
	}

	public String getTratamentPacient() {
		return this.tratamentPacient;
	}

	public void setTratamentPacient(String tratamentPacient) {
		this.tratamentPacient = tratamentPacient;
	}

	public int getVarstaPacient() {
		return this.varstaPacient;
	}

	public void setVarstaPacient(int varstaPacient) {
		this.varstaPacient = varstaPacient;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setPacient(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setPacient(null);

		return personal;
	}

}