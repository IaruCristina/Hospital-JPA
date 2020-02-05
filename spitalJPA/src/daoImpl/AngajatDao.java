package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Angajat;

public class AngajatDao implements Dao<Angajat> {

	private DatabaseHelper databaseHelper;

	public AngajatDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Angajat> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Angajat.class, id));
	}

	@Override
	public List<Angajat> getAll() {
		TypedQuery<Angajat> query = databaseHelper.getEntityManager().createQuery("SELECT a FROM Angajat a",
				Angajat.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Angajat angajat) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(angajat));
	}

	@Override
	public boolean update(Angajat old, Angajat newObj) {
		old.setIdAngajat(newObj.getIdAngajat());
		old.setFunctieAngajat(newObj.getFunctieAngajat());
		old.setNumeAngajat(newObj.getNumeAngajat());
		old.setVarstaAngajat(newObj.getVarstaAngajat());
		old.setFurnizors(newObj.getFurnizors());
		old.setPersonals(newObj.getPersonals());
		old.setSalarius(newObj.getSalarius());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Angajat angajat) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(angajat));
	}
}
