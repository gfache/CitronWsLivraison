package fr.afcepf.al33.projet2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.afcepf.al33.projet2.action.AskOpenRouteService;

@Component
//@Profile("test")
public class TestGeoWS {
	
	@Autowired
	AskOpenRouteService myOpenRouteService=null;
	
	@PostConstruct
	public void test(){
		// TODO Auto-generated method stub
		//TestGeoWS testGeoWS = new TestGeoWS();

		String addressA ="84 rue Marcadet 75018 Paris";
		String addressB ="26 route de narcy 52410 Chamouilley";
		System.out.println(addressA);

		Double myDistance=null;
		
		myDistance = myOpenRouteService.getDistanceBetween2Addresses(addressA, addressB);
		System.out.println(myDistance);
				
	}



}
