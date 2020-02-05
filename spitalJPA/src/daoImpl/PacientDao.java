package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Pacient;

public class PacientDao implements Dao<Pacient>{
	private DatabaseHelper databaseHelper;

	public PacientDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Pacient> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Pacient.class, id));
	}

	@Override
	public List<Pacient> getAll() {
		TypedQuery<Pacient> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM Pacient p",
				Pacient.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Pacient pacient) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(pacient));
	}

	@Override
	public boolean update(Pacient old, Pacient newObj) {
		old.setIdPacient(newObj.getIdPacient());
		old.setBoalaPacient(newObj.getBoalaPacient());
		old.setNumePacient(newObj.getNumePacient());
		old.setTratamentPacient(newObj.getTratamentPacient());
		old.setVarstaPacient(newObj.getVarstaPacient());
		old.setPersonals(newObj.getPersonals());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Pacient pacient) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(pacient));
	}
}
