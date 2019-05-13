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
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Address> getAllAddress() {
//		String hql = "FROM address as addr ORDER BY addr.address_id";
//		return (List<Address>) entityManager.createQuery(hql).getResultList();
//	}
//
//	@Override
//	public Address getAddressById(Long address_id) {
//		return entityManager.find(Address.class, address_id);
//	}
//
//	@Override
//	public void addAddress(Address address) {
//		try {
//			entityManager.persist(address);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//	}
//
//	@Override
//	public void updateAddress(Address address) {
//		Address addr = getAddressById(address.getAddress_id());
//		addr.setBorough(address.getBorough());
//		addr.setContinent(address.getContinent());
//		addr.setCoordinates_0(address.getCoordinates_0());
//		addr.setCoordinates_1(address.getCoordinates_1());
//		addr.setCountry(address.getCountry());
//		addr.setCountry_a(address.getCountry_a());
//		addr.setGid(address.getGid());
//		addr.setHousenumber(address.getHousenumber());
//		addr.setLabel(address.getLabel());
//		addr.setLocaladmin(address.getLocaladmin());
//		addr.setLocality(address.getLocality());
//		addr.setMacroregion(address.getMacroregion());
//		addr.setPostalcode(address.getPostalcode());
//		addr.setRegion(address.getRegion());
//		addr.setStreet(address.getStreet());
//		entityManager.flush();
//
//	}
//
//	@Override
//	public void deleteAddress(Long address_id) {
//		entityManager.remove(getAddressById(address_id));
//	}
//
//	@Override
//	public boolean addressExists(String gid) {
//		String hql = "FROM address as addr WHERE addr.gid = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, gid).getResultList()
//				.size();
//		return count > 0 ? true : false;
//	}

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
