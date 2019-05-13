package fr.afcepf.al33.projet2.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.projet2.entity.Distance;

@Transactional
@Repository
public class DistanceDAO implements IDistanceDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Distance getDistanceById(int distanceId) {
		return entityManager.find(Distance.class, distanceId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Distance> getAllDistance() {
		String hql = "FROM Distance as dist ORDER BY dist.distanceId";
		return (List<Distance>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addDistance(Distance distance) {
		entityManager.persist(distance);
	}

	@Override
	public void updateDistance(Distance distance) {
		Distance dist = getDistanceById(distance.getDistanceId());
		dist.setLatitudeA(distance.getLatitudeA());
		dist.setLatitudeB(distance.getLatitudeB());
		dist.setLongitudeA(distance.getLongitudeA());
		dist.setLongitudeB(distance.getLongitudeB());
		dist.setDistance_a_to_b(distance.getDistance_a_to_b());
		entityManager.flush();
	}

	@Override
	public void deleteDistance(int distanceId) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean distanceExists(Double longitudeA, Double latitudeA,Double longitudeB, Double latitudeB) {
		String hql = "FROM Distance as dist WHERE dist.longitude_a = ? and dist.latitude_a = ? and dist.longitude_b = ? and dist.latitude_b = ?";
		int count = entityManager.createQuery(hql).setParameter(1, longitudeA).setParameter(2, latitudeA).setParameter(1, longitudeB).setParameter(2, latitudeB).getResultList()
				.size();
		return count > 0 ? true : false;
	}

}
