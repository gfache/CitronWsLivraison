package fr.afcepf.al33.projet2.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarbonFootprint {
	public static double TAUX_CONSOMMATION = 0.240;  // 0.240 litre/km
	public static double FACTEUR_EMISSION = 3.04; // 3.07 kg CO2/litre
	
	private Double distance;
	
	@Autowired
	AskOpenRouteService myOpenRouteService=null;
	
	public CarbonFootprint() {
		super();
	}

	public Double ProvideCo2Footprint() {
		Double co2Footprint = null;	
		co2Footprint = TAUX_CONSOMMATION*distance*FACTEUR_EMISSION;
		return co2Footprint;
	}

	public void setDistance(String addressA, String addressB) {
		Double myDistance = myOpenRouteService.getDistanceBetween2Addresses(addressA, addressB);
		distance = myDistance;
	}
	
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	

}
