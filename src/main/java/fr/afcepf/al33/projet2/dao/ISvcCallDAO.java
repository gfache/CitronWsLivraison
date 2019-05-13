package fr.afcepf.al33.projet2.dao;

import java.util.List;

import fr.afcepf.al33.projet2.entity.SvcCall;

public interface ISvcCallDAO {
	List<SvcCall> getAllCall();

	SvcCall getCallById(Integer svcCall_id);
	
	void addCall(SvcCall svcCall);
	
	void updateCall(SvcCall svcCall);
	
	void deleteCall(Integer svcCall_id);
	
	Integer callExists(String id_facture);
}
