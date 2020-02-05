package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the spor database table.
 * 
 */
@Entity
@NamedQuery(name="Spor.findAll", query="SELECT s FROM Spor s")
public class Spor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_spor")
	private int idSpor;

	@Column(name="s_calculator")
	private float sCalculator;

	@Column(name="s_garda")
	private float sGarda;

	@Column(name="s_toxicitate")
	private float sToxicitate;

	@Column(name="s_vechime")
	private float sVechime;

	//bi-directional many-to-one association to Salariu
	@OneToMany(mappedBy="spor")
	private List<Salariu> salarius;

	public Spor() {
	}

	public int getIdSpor() {
		return this.idSpor;
	}

	public void setIdSpor(int idSpor) {
		this.idSpor = idSpor;
	}

	public float getSCalculator() {
		return this.sCalculator;
	}

	public void setSCalculator(float sCalculator) {
		this.sCalculator = sCalculator;
	}

	public float getSGarda() {
		return this.sGarda;
	}

	public void setSGarda(float sGarda) {
		this.sGarda = sGarda;
	}

	public float getSToxicitate() {
		return this.sToxicitate;
	}

	public void setSToxicitate(float sToxicitate) {
		this.sToxicitate = sToxicitate;
	}

	public float getSVechime() {
		return this.sVechime;
	}

	public void setSVechime(float sVechime) {
		this.sVechime = sVechime;
	}

	public List<Salariu> getSalarius() {
		return this.salarius;
	}

	public void setSalarius(List<Salariu> salarius) {
		this.salarius = salarius;
	}

	public Salariu addSalarius(Salariu salarius) {
		getSalarius().add(salarius);
		salarius.setSpor(this);

		return salarius;
	}

	public Salariu removeSalarius(Salariu salarius) {
		getSalarius().remove(salarius);
		salarius.setSpor(null);

		return salarius;
	}

}