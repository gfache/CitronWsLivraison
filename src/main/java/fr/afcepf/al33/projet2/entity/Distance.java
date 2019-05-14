package fr.afcepf.al33.projet2.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distance")
public class Distance  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distance_id")
	private int distanceId;
	
	//Attributes of the point A
	@Column(name="longitude_a")
	private Double longitudeA;
	
	@Column(name="latitude_a")
	private Double latitudeA;
	
	//Attributes of the point B
	@Column(name="longitude_b")
	private Double longitudeB;
	
	@Column(name="latitude_b")
	private Double latitudeB;
	
	@Column(name="distance_a_to_b")
	private Double distance_a_to_b;

	
	@Column(name="distance_b_to_a")
	private Double distance_b_to_a;
	
	@Column(name="coordinates")
	private String coordinates;

	//Constructors
	public Distance() {
		super();
	}

	


	//Getters & Setters
	
	public int getDistanceId() {
		return distanceId;
	}

	public void setDistanceId(int distanceId) {
		this.distanceId = distanceId;
	}

	public Double getLongitudeA() {
		return longitudeA;
	}

	public void setLongitudeA(Double longitudeA) {
		this.longitudeA = longitudeA;
	}

	public Double getLatitudeA() {
		return latitudeA;
	}

	public void setLatitudeA(Double latitudeA) {
		this.latitudeA = latitudeA;
	}

	public Double getLongitudeB() {
		return longitudeB;
	}

	public void setLongitudeB(Double longitudeB) {
		this.longitudeB = longitudeB;
	}

	public Double getLatitudeB() {
		return latitudeB;
	}

	public void setLatitudeB(Double latitudeB) {
		this.latitudeB = latitudeB;
	}

	public Double getDistance_a_to_b() {
		return distance_a_to_b;
	}

	public void setDistance_a_to_b(Double distance_a_to_b) {
		this.distance_a_to_b = distance_a_to_b;
	}

	public Double getDistance_b_to_a() {
		return distance_b_to_a;
	}

	public void setDistance_b_to_a(Double distance_b_to_a) {
		this.distance_b_to_a = distance_b_to_a;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getCoordinates() {
		return coordinates;
	}




	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	


	
	
	
	

}
