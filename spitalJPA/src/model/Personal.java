package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class Personal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personal")
	private int idPersonal;

	//bi-directional many-to-one association to Angajat
	@ManyToOne
	@JoinColumn(name="id_angajat")
	private Angajat angajat;

	//bi-directional many-to-one association to Departament
	@ManyToOne
	@JoinColumn(name="id_departament")
	private Departament departament;

	//bi-directional many-to-one association to Pacient
	@ManyToOne
	@JoinColumn(name="id_pacient")
	private Pacient pacient;

	public Personal() {
	}

	public int getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Angajat getAngajat() {
		return this.angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Departament getDepartament() {
		return this.departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public Pacient getPacient() {
		return this.pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

}