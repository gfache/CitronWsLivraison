package fr.afcepf.al33.projet2.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.projet2.action.CarbonFootprint;
import fr.afcepf.al33.projet2.action.PriceCalculation;
import fr.afcepf.al33.projet2.entity.SvcCall;

@Transactional
@Repository
public class SvcCallDAO  implements ISvcCallDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	PriceCalculation myPriceCalculation;
	
	@Autowired
	CarbonFootprint myCarbonFootprint;

	@Override
	public List<SvcCall> getAllCall() {
		String hql = "FROM SvcCall as sca ORDER BY sca.call_id";
		return (List<SvcCall>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public SvcCall getCallById(Integer call_id) {
		return entityManager.find(SvcCall.class, call_id);
	}

	@Override
	public void addCall(SvcCall call) {
		//Calculation of the delivery cost
		myPriceCalculation.setDistance(call.getAddress_a(), call.getAddress_b());
		call.setDistance_a_b(myPriceCalculation.getDistance());
		call.setDelivery_price(myPriceCalculation.ProvidePrice(call.getDistance_a_b()));
		
		//Calculation of the carbon footprint
		myCarbonFootprint.setDistance(myPriceCalculation.getDistance());
		call.setCo2_footprint(myCarbonFootprint.ProvideCo2Footprint());
		
		//Save the object in DB
		entityManager.persist(call);
		
	}

	@Override
	public void updateCall(SvcCall call) {
		SvcCall myCall = getCallById(call.getCall_id());
		myCall.setAddress_a(call.getAddress_a());
		myCall.setAddress_b(call.getAddress_b());
		myCall.setCo2_footprint(call.getCo2_footprint());
		myCall.setCompany(call.getCompany());
		myCall.setDate_commande(call.getDate_commande());
		myCall.setDelivery_price(call.getDelivery_price());
		myCall.setDistance_a_b(call.getDistance_a_b());
		myCall.setId_facture(call.getId_facture());
		entityManager.flush();		
	}

	@Override
	public void deleteCall(Integer call_id) {
		//To do
		
	}

	@Override
	public Integer callExists(String id_facture) {
		String hql = "FROM SvcCall as vccall WHERE vccall.id_facture = :idFacture";
		System.out.println("SvcCallDAO.callExists Hql->   \""+ hql + "\" And the Id facture to check is "+ id_facture);
		int count = entityManager.createQuery(hql).setParameter("idFacture", id_facture).getResultList().size();
		if (count > 0) {
			SvcCall myCall = (SvcCall) entityManager.createQuery(hql).setParameter("idFacture", id_facture).getResultList().get(0);
			return myCall.getCall_id();
		}
		else {
			return 0;
		}
	}
	


}
