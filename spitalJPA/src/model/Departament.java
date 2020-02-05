package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departament database table.
 * 
 */
@Entity
@NamedQuery(name="Departament.findAll", query="SELECT d FROM Departament d")
public class Departament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_departament")
	private int idDepartament;

	@Column(name="capacitate_departament")
	private int capacitateDepartament;

	@Column(name="etaj_departament")
	private String etajDepartament;

	@Column(name="numar_aparate")
	private int numarAparate;

	@Column(name="nume_departament")
	private String numeDepartament;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="departament")
	private List<Personal> personals;

	public Departament() {
	}

	public int getIdDepartament() {
		return this.idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public int getCapacitateDepartament() {
		return this.capacitateDepartament;
	}

	public void setCapacitateDepartament(int capacitateDepartament) {
		this.capacitateDepartament = capacitateDepartament;
	}

	public String getEtajDepartament() {
		return this.etajDepartament;
	}

	public void setEtajDepartament(String etajDepartament) {
		this.etajDepartament = etajDepartament;
	}

	public int getNumarAparate() {
		return this.numarAparate;
	}

	public void setNumarAparate(int numarAparate) {
		this.numarAparate = numarAparate;
	}

	public String getNumeDepartament() {
		return this.numeDepartament;
	}

	public void setNumeDepartament(String numeDepartament) {
		this.numeDepartament = numeDepartament;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setDepartament(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setDepartament(null);

		return personal;
	}

}