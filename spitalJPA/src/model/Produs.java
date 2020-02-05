package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produs database table.
 * 
 */
@Entity
@NamedQuery(name="Produs.findAll", query="SELECT p FROM Produs p")
public class Produs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_produs")
	private int idProdus;

	@Column(name="cantitate_produs")
	private int cantitateProdus;

	@Column(name="nume_produs")
	private String numeProdus;

	@Column(name="pret_produs")
	private float pretProdus;

	//bi-directional many-to-one association to Furnizor
	@ManyToOne
	@JoinColumn(name="id_furnizor")
	private Furnizor furnizor;

	public Produs() {
	}

	public int getIdProdus() {
		return this.idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getCantitateProdus() {
		return this.cantitateProdus;
	}

	public void setCantitateProdus(int cantitateProdus) {
		this.cantitateProdus = cantitateProdus;
	}

	public String getNumeProdus() {
		return this.numeProdus;
	}

	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}

	public float getPretProdus() {
		return this.pretProdus;
	}

	public void setPretProdus(float pretProdus) {
		this.pretProdus = pretProdus;
	}

	public Furnizor getFurnizor() {
		return this.furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}

}