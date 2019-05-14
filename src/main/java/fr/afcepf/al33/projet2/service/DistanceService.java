package fr.afcepf.al33.projet2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al33.projet2.dao.IDistanceDAO;
import fr.afcepf.al33.projet2.entity.Distance;

@Service
public class DistanceService implements IDistanceService {

	@Autowired
	private IDistanceDAO distanceDAO;

	@Override
	public List<Distance> getAllDistance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Distance getDistanceById(int distanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDistance(Distance distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDistance(int distanceId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	@Override
//	public List<Distance> getAllDistance() {
//		return distanceDAO.getAllDistance();
//	}
//	
//	@Override
//	public Distance getDistanceById(int distanceId) {
//		Distance distance = distanceDAO.getDistanceById(distanceId);
//		return distance;
//	}
//
//	@Override
//	public synchronized boolean addDistance(Distance distance) {
//		if (distanceDAO.distanceExists(distance.getLongitudeA(), distance.getLatitudeA(), distance.getLongitudeB(), distance.getLatitudeB())) {
//			return false;
//		} else {
//			distanceDAO.addDistance(distance);
//			return true;
//		}
//	}
//
//	@Override
//	public void updateDistance(Distance distance) {
//		distanceDAO.updateDistance(distance);
//	}
//
//	@Override
//	public void deleteDistance(int distanceId) {
//		distanceDAO.deleteDistance(distanceId);
//	}

}
