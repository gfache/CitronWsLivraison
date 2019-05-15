package fr.afcepf.al33.projet2.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.afcepf.al33.projet2.dao.IAddressDAO;
import fr.afcepf.al33.projet2.entity.Address;

//@Controller
@Component
public class AddressControler {
    @Autowired
    private IAddressDAO addressDAO;
    
	public AddressControler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addAddress(JSONObject obj) {
		
		Address addressToInsert = new Address();
		if (obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").has("borough"))
		{
			addressToInsert.setBorough(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("borough"));
		}
		addressToInsert.setContinent(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("continent"));
		addressToInsert.setCoordinates_0(obj.getJSONArray("features").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").getDouble(0));
		addressToInsert.setCoordinates_1(obj.getJSONArray("features").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates").getDouble(1));
		addressToInsert.setCountry(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("country"));
		addressToInsert.setCountry_a(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("country_a"));
		addressToInsert.setGid(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("gid"));
		addressToInsert.setHousenumber(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("housenumber"));
		addressToInsert.setLabel(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("label"));
		
		if (obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").has("localadmin"))
		{
			addressToInsert.setLocaladmin(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("localadmin"));
		}
		
		
		addressToInsert.setLocality(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("locality"));
		addressToInsert.setMacroregion(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("macroregion"));
		if (obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").has("postalcode"))
		{
			addressToInsert.setPostalcode(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("postalcode"));
		}
		addressToInsert.setRegion(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("region"));
		addressToInsert.setStreet(obj.getJSONArray("features").getJSONObject(0).getJSONObject("properties").getString("street"));
		
		try {
			addressDAO.save(addressToInsert);
			System.out.println("I'm in "+ this.getClass().getName());

		} catch (Exception e) {
			System.out.println(e);
		}
	}



}
