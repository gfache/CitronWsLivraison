package fr.afcepf.al33.projet2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "svccall")
public class SvcCall {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "call_id")
	private Integer call_id;
	
	@Column(name="id_facture", nullable=false)
	private String id_facture;
	
	@Column(name="address_a")
	private String address_a;
	
	@Column(name="address_b")
	private String address_b;
	
	@Column(name="distance_a_b")
	private Double distance_a_b;
	
	@Column(name="delivery_price")
	private Double delivery_price;
	
	@Column(name="co2_footprint")
	private Double co2_footprint;
	
	@Column(name="date_commande")
	private Date date_commande;
		
	@Column(name="company")
	private String company;

	
	public Integer getCall_id() {
		return call_id;
	}

	public void setCall_id(Integer call_id) {
		this.call_id = call_id;
	}

	public String getId_facture() {
		return id_facture;
	}

	public void setId_facture(String id_facture) {
		this.id_facture = id_facture;
	}

	public String getAddress_a() {
		return address_a;
	}

	public void setAddress_a(String address_a) {
		this.address_a = address_a;
	}

	public String getAddress_b() {
		return address_b;
	}

	public void setAddress_b(String address_b) {
		this.address_b = address_b;
	}

	public Double getDistance_a_b() {
		return distance_a_b;
	}

	public void setDistance_a_b(Double distance_a_b) {
		this.distance_a_b = distance_a_b;
	}

	public Double getDelivery_price() {
		return delivery_price;
	}

	public void setDelivery_price(Double delivery_price) {
		this.delivery_price = delivery_price;
	}

	public Double getCo2_footprint() {
		return co2_footprint;
	}

	public void setCo2_footprint(Double co2_footprint) {
		this.co2_footprint = co2_footprint;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	
	


	
	//Getters setters
	
}
