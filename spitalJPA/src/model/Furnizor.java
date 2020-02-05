package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the furnizor database table.
 * 
 */
@Entity
@NamedQuery(name="Furnizor.findAll", query="SELECT f FROM Furnizor f")
public class Furnizor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_furnizor")
	private int idFurnizor;

	@Column(name="adresa_furnizor")
	private String adresaFurnizor;

	@Column(name="nr_telefon_furnizor")
	private String nrTelefonFurnizor;

	@Column(name="nume_furnizor")
	private String numeFurnizor;

	//bi-directional many-to-one association to Angajat
	@ManyToOne
	@JoinColumn(name="id_angajat")
	private Angajat angajat;

	//bi-directional many-to-one association to Produs
	@OneToMany(mappedBy="furnizor")
	private List<Produs> produses;

	public Furnizor() {
	}

	public int getIdFurnizor() {
		return this.idFurnizor;
	}

	public void setIdFurnizor(int idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public String getAdresaFurnizor() {
		return this.adresaFurnizor;
	}

	public void setAdresaFurnizor(String adresaFurnizor) {
		this.adresaFurnizor = adresaFurnizor;
	}

	public String getNrTelefonFurnizor() {
		return this.nrTelefonFurnizor;
	}

	public void setNrTelefonFurnizor(String nrTelefonFurnizor) {
		this.nrTelefonFurnizor = nrTelefonFurnizor;
	}

	public String getNumeFurnizor() {
		return this.numeFurnizor;
	}

	public void setNumeFurnizor(String numeFurnizor) {
		this.numeFurnizor = numeFurnizor;
	}

	public Angajat getAngajat() {
		return this.angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public List<Produs> getProduses() {
		return this.produses;
	}

	public void setProduses(List<Produs> produses) {
		this.produses = produses;
	}

	public Produs addProdus(Produs produs) {
		getProduses().add(produs);
		produs.setFurnizor(this);

		return produs;
	}

	public Produs removeProdus(Produs produs) {
		getProduses().remove(produs);
		produs.setFurnizor(null);

		return produs;
	}

}