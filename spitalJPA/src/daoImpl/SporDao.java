package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Spor;

public class SporDao implements Dao<Spor> {
	private DatabaseHelper databaseHelper;

	public SporDao(DatabaseHelper databaseHelper) { 
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Spor> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Spor.class, id));
	}

	@Override
	public List<Spor> getAll() {
		TypedQuery<Spor> query = databaseHelper.getEntityManager().createQuery("SELECT s FROM Spor s",
				Spor.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Spor spor) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(spor));
	}

	@Override
	public boolean update(Spor old, Spor newObj) {
		old.setIdSpor(newObj.getIdSpor());
		old.setSCalculator(newObj.getSCalculator());
		old.setSGarda(newObj.getSGarda());
		old.setSToxicitate(newObj.getSToxicitate());
		old.setSVechime(newObj.getSVechime());
		old.setSalarius(newObj.getSalarius());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Spor spor) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(spor));
	}
}
