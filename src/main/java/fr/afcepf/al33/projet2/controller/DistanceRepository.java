package fr.afcepf.al33.projet2.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al33.projet2.dao.IDistanceDAO;
import fr.afcepf.al33.projet2.entity.Distance;

@Component
public class DistanceRepository {
    @Autowired
    private IDistanceDAO distanceDAO;
	
	public DistanceRepository() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public void addDistance(JSONObject obj,String coordinates_for_distance) {
		
		//Removing the not needed bracket of the coordinates string before spliting it by the comas
		String replaceString=coordinates_for_distance.replace("[","").replace("]","");
		System.out.println(coordinates_for_distance+ "-> "+ replaceString);
		String[] parts = replaceString.split(",");
				
		Distance distanceToInsert = new Distance();
		distanceToInsert.setDistance_a_to_b(obj.getJSONArray("distances").getJSONArray(0).getDouble(1));
		distanceToInsert.setDistance_b_to_a(obj.getJSONArray("distances").getJSONArray(1).getDouble(0));
		distanceToInsert.setCoordinates(coordinates_for_distance);
		distanceToInsert.setLatitudeA(Double.parseDouble(parts[0]));
		distanceToInsert.setLongitudeA(Double.parseDouble(parts[1]));
		distanceToInsert.setLatitudeB(Double.parseDouble(parts[2]));
		distanceToInsert.setLongitudeB(Double.parseDouble(parts[3]));
				
		try {
			System.out.println("DistanceRepository.addDistance");
			distanceDAO.save(distanceToInsert);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
