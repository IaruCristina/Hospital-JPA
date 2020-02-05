package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salariu database table.
 * 
 */
@Entity
@NamedQuery(name="Salariu.findAll", query="SELECT s FROM Salariu s")
public class Salariu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_salariu")
	private int idSalariu;

	@Column(name="ani_vechime")
	private int aniVechime;

	@Column(name="venit_brut")
	private float venitBrut;

	@Column(name="venit_net")
	private float venitNet;

	//bi-directional many-to-one association to Angajat
	@ManyToOne
	@JoinColumn(name="id_angajat")
	private Angajat angajat;

	//bi-directional many-to-one association to Spor
	@ManyToOne
	@JoinColumn(name="id_spor")
	private Spor spor;

	public Salariu() {
	}

	public int getIdSalariu() {
		return this.idSalariu;
	}

	public void setIdSalariu(int idSalariu) {
		this.idSalariu = idSalariu;
	}

	public int getAniVechime() {
		return this.aniVechime;
	}

	public void setAniVechime(int aniVechime) {
		this.aniVechime = aniVechime;
	}

	public float getVenitBrut() {
		return this.venitBrut;
	}

	public void setVenitBrut(float venitBrut) {
		this.venitBrut = venitBrut;
	}

	public float getVenitNet() {
		return this.venitNet;
	}

	public void setVenitNet(float venitNet) {
		this.venitNet = venitNet;
	}

	public Angajat getAngajat() {
		return this.angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Spor getSpor() {
		return this.spor;
	}

	public void setSpor(Spor spor) {
		this.spor = spor;
	}

}