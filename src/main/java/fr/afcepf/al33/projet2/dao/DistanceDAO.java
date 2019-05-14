package fr.afcepf.al33.projet2.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.projet2.entity.Address;
import fr.afcepf.al33.projet2.entity.Distance;

@Transactional
@Repository
public class DistanceDAO implements IDistanceDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <S extends Distance> S save(S entity) {
		try {
			entityManager.persist(entity);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public <S extends Distance> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Distance> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Distance> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Distance> findAllById(Iterable<Long> ids) {
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
	public void delete(Distance entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Distance> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	
	
//	@Override
//	public Distance getDistanceById(int distanceId) {
//		return entityManager.find(Distance.class, distanceId);
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Distance> getAllDistance() {
//		String hql = "FROM Distance as dist ORDER BY dist.distanceId";
//		return (List<Distance>) entityManager.createQuery(hql).getResultList();
//	}
//
//	@Override
//	public void addDistance(Distance distance) {
//		entityManager.persist(distance);
//	}
//
//	@Override
//	public void updateDistance(Distance distance) {
//		Distance dist = getDistanceById(distance.getDistanceId());
//		dist.setLatitudeA(distance.getLatitudeA());
//		dist.setLatitudeB(distance.getLatitudeB());
//		dist.setLongitudeA(distance.getLongitudeA());
//		dist.setLongitudeB(distance.getLongitudeB());
//		dist.setDistance_a_to_b(distance.getDistance_a_to_b());
//		entityManager.flush();
//	}
//
//	@Override
//	public void deleteDistance(int distanceId) {
//		// TODO Auto-generated method stub
//
//	}
//	
//	@Override
//	public boolean distanceExists(Double longitudeA, Double latitudeA,Double longitudeB, Double latitudeB) {
//		String hql = "FROM Distance as dist WHERE dist.longitude_a = ? and dist.latitude_a = ? and dist.longitude_b = ? and dist.latitude_b = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, longitudeA).setParameter(2, latitudeA).setParameter(1, longitudeB).setParameter(2, latitudeB).getResultList()
//				.size();
//		return count > 0 ? true : false;
//	}

}
