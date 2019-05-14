package fr.afcepf.al33.projet2.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import fr.afcepf.al33.projet2.entity.Distance;

public interface IDistanceDAO extends CrudRepository<Distance, Long> {
	//boolean distanceExists(Double longitudeA, Double latitudeA,Double longitudeB, Double latitudeB);

}

