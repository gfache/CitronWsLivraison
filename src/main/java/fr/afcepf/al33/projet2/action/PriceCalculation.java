package fr.afcepf.al33.projet2.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceCalculation {
	
	private Double distance;
	
	@Autowired
	AskOpenRouteService myOpenRouteService=null;
	
	public PriceCalculation() {
		super();
	}

	public void setDistance(String addressA, String addressB) {
		Double myDistance = myOpenRouteService.getDistanceBetween2Addresses(addressA, addressB);
		distance = myDistance;
	}

	public Double ProvidePrice(Double distance) {
		Double result=null;
				
		if(distance<10) {
			result = 5.50;
		} else if (distance>=10 && distance<100) {
			result = 9.99;
		}else if (distance>100) {
			result = 15.0;
		}
		
		return result;
	}



	public Double getDistance() {
		return distance;
	}



	public void setDistance(Double distance) {
		this.distance = distance;
	}



	
}
