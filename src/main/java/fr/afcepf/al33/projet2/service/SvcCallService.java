package fr.afcepf.al33.projet2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al33.projet2.dao.ISvcCallDAO;
import fr.afcepf.al33.projet2.entity.SvcCall;

@Service
public class SvcCallService implements ISvcCallService{

	@Autowired
	private ISvcCallDAO callDAO;
	
	@Override
	public List<SvcCall> getAllCall() {
		return callDAO.getAllCall();
	}
	
	@Override
	public SvcCall getCallById(Integer callId) {
		SvcCall call = callDAO.getCallById(callId);
		return call;
	}

	@Override
	public synchronized Integer addCall(SvcCall call) {
		System.out.println("SvcCallService -> Id facture:" + call.getId_facture());
		Integer callId = callDAO.callExists(call.getId_facture());
		System.out.println("SvcCallService -> Call Id:" + callId);
		if (callId>=1) {
			return callId;
		} else {
			callDAO.addCall(call);
			return 0;
		}
	}

	@Override
	public void updateCall(SvcCall call) {
		callDAO.updateCall(call);
	}

	@Override
	public void deleteCall(Integer callId) {
		callDAO.deleteCall(callId);
	}

	
}
