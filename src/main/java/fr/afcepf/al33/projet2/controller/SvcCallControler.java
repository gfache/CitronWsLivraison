package fr.afcepf.al33.projet2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import fr.afcepf.al33.projet2.entity.SvcCall;
import fr.afcepf.al33.projet2.service.ISvcCallService;

@Controller
@RequestMapping("livraison")
public class SvcCallControler {
	@Autowired
	private ISvcCallService callService;
	
	@GetMapping("svccall/{id}")
	public ResponseEntity<SvcCall> getCallById(@PathVariable("id") Integer id) {
		SvcCall call = callService.getCallById(id);
		return new ResponseEntity<SvcCall>(call, HttpStatus.OK);
	}

	@GetMapping("svccall")
	public ResponseEntity<List<SvcCall>> getAllCalls() {
		List<SvcCall> list = callService.getAllCall();
		return new ResponseEntity<List<SvcCall>>(list, HttpStatus.OK);
	}

	@PostMapping("svccall")
	public ResponseEntity<Void> addCall(@RequestBody SvcCall call, UriComponentsBuilder builder) {
		System.out.println("SvcCallControler -> date commande : "+ call.getDate_commande() + " And Id facture is : "+call.getId_facture());
		Integer flag = callService.addCall(call);
		HttpHeaders headers = new HttpHeaders();
		if (flag != null && flag != 0) {
			headers.setLocation(builder.path("/svccall/"+flag).buildAndExpand(call.getCall_id()).toUri());
			System.out.println("@PostMapping >=1 -> "+headers.getLocation());
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
		headers.setLocation(builder.path("/svccall/{id}").buildAndExpand(call.getCall_id()).toUri());
		System.out.println("@PostMapping ==0 -> "+headers.getLocation());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("svccall")
	public ResponseEntity<SvcCall> updateCall(@RequestBody SvcCall call) {
		callService.updateCall(call);
		return new ResponseEntity<SvcCall>(call, HttpStatus.OK);
	}

	@DeleteMapping("svccall/{id}")
	public ResponseEntity<Void> deleteCall(@PathVariable("id") Integer id) {
		callService.deleteCall(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
