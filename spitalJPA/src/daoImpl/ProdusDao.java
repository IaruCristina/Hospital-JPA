package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Produs;

public class ProdusDao implements Dao<Produs>{
	private DatabaseHelper databaseHelper;

	public ProdusDao(DatabaseHelper databaseHelper) { 
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Produs> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Produs.class, id));
	}

	@Override
	public List<Produs> getAll() {
		TypedQuery<Produs> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM Produs p",
				Produs.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Produs produs) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(produs));
	}

	@Override
	public boolean update(Produs old, Produs newObj) {
		old.setIdProdus(newObj.getIdProdus());
		old.setCantitateProdus(newObj.getCantitateProdus());
		old.setNumeProdus(newObj.getNumeProdus());
		old.setPretProdus(newObj.getPretProdus());
		old.setFurnizor(newObj.getFurnizor());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Produs produs) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(produs));
	}
}
