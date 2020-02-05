package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Furnizor;

public class FurnizorDao implements Dao<Furnizor>{
	private DatabaseHelper databaseHelper;

	public FurnizorDao(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Furnizor> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Furnizor.class, id));
	}

	@Override
	public List<Furnizor> getAll() {
		TypedQuery<Furnizor> query = databaseHelper.getEntityManager().createQuery("SELECT f FROM Furnizor f",
				Furnizor.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Furnizor furnizor) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(furnizor));
	}

	@Override
	public boolean update(Furnizor old, Furnizor newObj) {
		old.setIdFurnizor(newObj.getIdFurnizor());
		old.setAdresaFurnizor(newObj.getAdresaFurnizor());
		old.setNrTelefonFurnizor(newObj.getNrTelefonFurnizor());
		old.setNumeFurnizor(newObj.getNumeFurnizor());
		old.setAngajat(newObj.getAngajat());
		old.setProduses(newObj.getProduses());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Furnizor furnizor) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(furnizor));
	}
}
