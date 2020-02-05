package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Salariu;

public class SalariuDao implements Dao<Salariu> {
	private DatabaseHelper databaseHelper;

	public SalariuDao(DatabaseHelper databaseHelper) { 
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Salariu> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Salariu.class, id));
	}

	@Override
	public List<Salariu> getAll() {
		TypedQuery<Salariu> query = databaseHelper.getEntityManager().createQuery("SELECT s FROM Salariu s",
				Salariu.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Salariu salariu) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(salariu));
	}

	@Override
	public boolean update(Salariu old, Salariu newObj) {
		old.setIdSalariu(newObj.getIdSalariu());
		old.setAniVechime(newObj.getAniVechime());
		old.setVenitBrut(newObj.getVenitBrut());
		old.setVenitNet(newObj.getVenitNet());
		old.setAngajat(newObj.getAngajat());
		old.setSpor(newObj.getSpor());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Salariu salariu) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(salariu));
	}
}
