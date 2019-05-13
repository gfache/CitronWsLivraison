package fr.afcepf.al33.projet2.action;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al33.projet2.controller.AddressControler;
import fr.afcepf.al33.projet2.dao.IAddressDAO;
import fr.afcepf.al33.projet2.entity.Address;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@Component
public class AskOpenRouteService {

	@Autowired
	AddressControler myAddressControler;
	
	
	@Autowired
	AskOpenRouteService myOpenRouteService ;
	
	private String api_key = "5b3ce3597851110001cf624803b766f5894f4ff5ac3e0ca9f6932bb5";
	private String address = "";
	private String coordinates_for_distance = "";

	// Constructors
	public AskOpenRouteService() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Methode to provide the distance between 2 addresses
	public Double getDistanceBetween2Addresses(String addressA, String addressB) {
		Double result = null;

		
		// Get coordinate for point A
		myOpenRouteService.setAddress(addressA);
		String mycoordinateA = myOpenRouteService.getCoordinates();
		// Get coordinate for point B
		myOpenRouteService.setAddress(addressB);
		String mycoordinateB = myOpenRouteService.getCoordinates();
		// Get distance between point A and B
		String coordinates_A_to_B = "[" + mycoordinateA + "," + mycoordinateB + "]";
		myOpenRouteService.setCoordinates_for_distance(coordinates_A_to_B);
		System.out.println(coordinates_A_to_B);
		result = myOpenRouteService.calculateDistance();
		return result;
	}

	// Method for getting the coordinates related to an address and storing the
	// address in the database
	public String getCoordinates() {
		Double coordinat_lat;
		Double coordinat_lon;
		String fctResult;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String uri = String.format("https://api.openrouteservice.org/geocode/search?api_key=%s&text=%s", api_key,
				address);
		String result = restTemplate.getForObject(uri, String.class);
		// System.out.println(result);

		// Parsing of the Json object to get the coordinates
		JSONObject obj = new JSONObject(result);
		coordinat_lat = obj.getJSONArray("features").getJSONObject(0).getJSONObject("geometry")
				.getJSONArray("coordinates").getDouble(0);
		coordinat_lon = obj.getJSONArray("features").getJSONObject(0).getJSONObject("geometry")
				.getJSONArray("coordinates").getDouble(1);
		fctResult = "[" + coordinat_lat.toString() + "," + coordinat_lon.toString() + "]";

		//Add the new address obtained to the database 
		
		myAddressControler.addAddress(obj);

		return fctResult;

	}

	public Double calculateDistance() {
		Double distance = null;

		Client client = ClientBuilder.newClient();
		Entity<String> payload = Entity
				.json("{\"locations\":" + coordinates_for_distance + ",\"metrics\":[\"distance\"],\"units\":\"km\"}");
		Response response = client.target("https://api.openrouteservice.org/v2/matrix/driving-car").request()
				.header("Authorization", "5b3ce3597851110001cf624803b766f5894f4ff5ac3e0ca9f6932bb5")
				.header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
				.post(payload);

		// System.out.println("status: " + response.getStatus());
		// System.out.println("headers: " + response.getHeaders());
		// System.out.println("body:" + response.readEntity(String.class));

		// Parsing of the Json object
		JSONObject obj = new JSONObject(response.readEntity(String.class));
		// distance =
		// obj.getJSONArray("distances").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").getDouble(0);
		System.out.println("coucou");

		ArrayList<String> listdata = new ArrayList<String>();
		JSONArray jArray = (JSONArray) obj.getJSONArray("distances").getJSONArray(0);//.getJSONArray(1);
		String toto = jArray.toString();
		System.out.println("toto");
		distance =  obj.getJSONArray("distances").getJSONArray(0).getDouble(1);
		// distance = obj.getJSONArray("distances").getDouble(0);
		return distance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCoordinates_for_distance() {
		return coordinates_for_distance;
	}

	public void setCoordinates_for_distance(String coordinates_for_distance) {
		this.coordinates_for_distance = coordinates_for_distance;
	}

}
