package daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import dao.Dao;
import helper.DatabaseHelper;
import model.Personal;

public class PersonalDao implements Dao<Personal> {
	private DatabaseHelper databaseHelper;

	public PersonalDao(DatabaseHelper databaseHelper) { 
		this.databaseHelper = databaseHelper;
	}

	@Override
	public Optional<Personal> get(int id) {
		return Optional.ofNullable(databaseHelper.getEntityManager().find(Personal.class, id));
	}

	@Override
	public List<Personal> getAll() {
		TypedQuery<Personal> query = databaseHelper.getEntityManager().createQuery("SELECT p FROM Personal p",
				Personal.class);
		return query.getResultList();
	}

	@Override
	public boolean create(Personal personal) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.persist(personal));
	}

	@Override
	public boolean update(Personal old, Personal newObj) {
		old.setIdPersonal(newObj.getIdPersonal());
		old.setAngajat(newObj.getAngajat());
		old.setDepartament(newObj.getDepartament());
		old.setPacient(newObj.getPacient());
		return databaseHelper.executeTransaction(entityManager -> entityManager.merge(old));
	}

	@Override
	public boolean delete(Personal personal) {
		return databaseHelper.executeTransaction(entityManager -> entityManager.remove(personal));
	}
}
