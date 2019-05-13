package fr.afcepf.al33.projet2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long address_id;
	
	@Column(name="gid")
	private String gid;
	
	@Column(name="housenumber")
	private String housenumber;
	
	@Column(name="street")
	private String street;
	
	@Column(name="postalcode")
	private String postalcode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="country_a")
	private String country_a;
	
	@Column(name="macroregion")
	private String macroregion;
	
	@Column(name="region")
	private String region;
	
	@Column(name="localadmin")
	private String localadmin;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="borough")
	private String borough;
	
	@Column(name="continent")
	private String continent;
	
	@Column(name="label")
	private String label;
	
	@Column(name="coordinates_0")
	private Double coordinates_0;
	
	@Column(name="coordinates_1")
	private Double coordinates_1;

	
	//Constructors
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//Getters and setters
	
	public Long getAddress_id() {
		return address_id;
	}


	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}


	public String getGid() {
		return gid;
	}


	public void setGid(String gid) {
		this.gid = gid;
	}


	public String getHousenumber() {
		return housenumber;
	}


	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getPostalcode() {
		return postalcode;
	}


	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountry_a() {
		return country_a;
	}


	public void setCountry_a(String country_a) {
		this.country_a = country_a;
	}


	public String getMacroregion() {
		return macroregion;
	}


	public void setMacroregion(String macroregion) {
		this.macroregion = macroregion;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getLocaladmin() {
		return localadmin;
	}


	public void setLocaladmin(String localadmin) {
		this.localadmin = localadmin;
	}


	public String getLocality() {
		return locality;
	}


	public void setLocality(String locality) {
		this.locality = locality;
	}


	public String getBorough() {
		return borough;
	}


	public void setBorough(String borough) {
		this.borough = borough;
	}


	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public Double getCoordinates_0() {
		return coordinates_0;
	}


	public void setCoordinates_0(Double coordinates_0) {
		this.coordinates_0 = coordinates_0;
	}


	public Double getCoordinates_1() {
		return coordinates_1;
	}


	public void setCoordinates_1(Double coordinates_1) {
		this.coordinates_1 = coordinates_1;
	}	
	

	
}
