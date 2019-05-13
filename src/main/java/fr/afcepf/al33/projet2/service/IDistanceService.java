package fr.afcepf.al33.projet2.service;

import java.util.List;

import fr.afcepf.al33.projet2.entity.Distance;

public interface IDistanceService {
	List<Distance> getAllDistance();

	Distance getDistanceById(int distanceId);
	
	boolean addDistance(Distance distance);
	
	void updateDistance(Distance distance);
	
	void deleteDistance(int distanceId);
}
