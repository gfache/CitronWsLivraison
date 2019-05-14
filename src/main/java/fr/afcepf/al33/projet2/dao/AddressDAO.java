package fr.afcepf.al33.projet2.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.projet2.entity.Address;

@Transactional
@Repository
public class AddressDAO implements IAddressDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public <S extends Address> S save(S entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public <S extends Address> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Address> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Address> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Address> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Address entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Address> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



}
