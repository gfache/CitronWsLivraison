package fr.afcepf.al33.projet2.controller;

import java.util.List;

import org.json.JSONObject;
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
import fr.afcepf.al33.projet2.entity.Distance;
import fr.afcepf.al33.projet2.service.IDistanceService;

@Controller
@RequestMapping("livraison2")
public class DistanceControler {
	@Autowired
	private IDistanceService distanceService;
	
	@GetMapping("distance/{id}")
	public ResponseEntity<Distance> getDistanceById(@PathVariable("id") Integer id) {
		Distance distance = distanceService.getDistanceById(id);
		return new ResponseEntity<Distance>(distance, HttpStatus.OK);
	}

	@GetMapping("distances")
	public ResponseEntity<List<Distance>> getAllDistances() {
		List<Distance> list = distanceService.getAllDistance();
		return new ResponseEntity<List<Distance>>(list, HttpStatus.OK);
	}

	@PostMapping("distance")
	public ResponseEntity<Void> addDistance(@RequestBody Distance distance, UriComponentsBuilder builder) {
		boolean flag = distanceService.addDistance(distance);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/distance/{id}").buildAndExpand(distance.getDistanceId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("distance")
	public ResponseEntity<Distance> updateDistance(@RequestBody Distance distance) {
		distanceService.updateDistance(distance);
		return new ResponseEntity<Distance>(distance, HttpStatus.OK);
	}

	@DeleteMapping("distance/{id}")
	public ResponseEntity<Void> deleteDistance(@PathVariable("id") Integer id) {
		distanceService.deleteDistance(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	

}
