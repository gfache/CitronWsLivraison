package fr.afcepf.al33.projet2.service;

import java.util.List;

import fr.afcepf.al33.projet2.entity.SvcCall;

public interface ISvcCallService {
	List<SvcCall> getAllCall();

	SvcCall getCallById(Integer id);
	
	Integer addCall(SvcCall svcCall);
	
	void updateCall(SvcCall svcCall);
	
	void deleteCall(Integer svcCall_id);

}
