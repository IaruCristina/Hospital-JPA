package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the angajat database table.
 * 
 */
@Entity
@NamedQuery(name="Angajat.findAll", query="SELECT a FROM Angajat a")
public class Angajat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_angajat")
	private int idAngajat;

	@Column(name="functie_angajat")
	private String functieAngajat;

	@Column(name="nume_angajat")
	private String numeAngajat;

	@Column(name="varsta_angajat")
	private int varstaAngajat;

	//bi-directional many-to-one association to Furnizor
	@OneToMany(mappedBy="angajat")
	private List<Furnizor> furnizors;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="angajat")
	private List<Personal> personals;

	//bi-directional many-to-one association to Salariu
	@OneToMany(mappedBy="angajat")
	private List<Salariu> salarius;

	public Angajat() {
	}
	
	public Angajat(int idA,String functieA,String numeA,int varstaA) {
		this.idAngajat=idA;
		this.functieAngajat=functieA;
		this.numeAngajat=numeA;
		this.varstaAngajat=varstaA;
	}
	
	public int getIdAngajat() {
		return this.idAngajat;
	}

	public void setIdAngajat(int idAngajat) {
		this.idAngajat = idAngajat;
	}

	public String getFunctieAngajat() {
		return this.functieAngajat;
	}

	public void setFunctieAngajat(String functieAngajat) {
		this.functieAngajat = functieAngajat;
	}

	public String getNumeAngajat() {
		return this.numeAngajat;
	}

	public void setNumeAngajat(String numeAngajat) {
		this.numeAngajat = numeAngajat;
	}

	public int getVarstaAngajat() {
		return this.varstaAngajat;
	}

	public void setVarstaAngajat(int varstaAngajat) {
		this.varstaAngajat = varstaAngajat;
	}

	public List<Furnizor> getFurnizors() {
		return this.furnizors;
	}

	public void setFurnizors(List<Furnizor> furnizors) {
		this.furnizors = furnizors;
	}

	public Furnizor addFurnizor(Furnizor furnizor) {
		getFurnizors().add(furnizor);
		furnizor.setAngajat(this);

		return furnizor;
	}

	public Furnizor removeFurnizor(Furnizor furnizor) {
		getFurnizors().remove(furnizor);
		furnizor.setAngajat(null);

		return furnizor;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setAngajat(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setAngajat(null);

		return personal;
	}

	public List<Salariu> getSalarius() {
		return this.salarius;
	}

	public void setSalarius(List<Salariu> salarius) {
		this.salarius = salarius;
	}

	public Salariu addSalarius(Salariu salarius) {
		getSalarius().add(salarius);
		salarius.setAngajat(this);

		return salarius;
	}

	public Salariu removeSalarius(Salariu salarius) {
		getSalarius().remove(salarius);
		salarius.setAngajat(null);

		return salarius;
	}

}