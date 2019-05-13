package fr.afcepf.al33.projet2.dao;

import java.util.List;
import fr.afcepf.al33.projet2.entity.Distance;

public interface IDistanceDAO {
	List<Distance> getAllDistance();

	Distance getDistanceById(int distanceId);
	
	void addDistance(Distance distance);
	
	void updateDistance(Distance distance);
	
	void deleteDistance(int distanceId);

	boolean distanceExists(Double longitudeA, Double latitudeA,Double longitudeB, Double latitudeB);

}
