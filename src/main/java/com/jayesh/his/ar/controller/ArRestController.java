package com.jayesh.his.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.his.ar.binding.CitizenApp;
import com.jayesh.his.ar.service.ArService;

@RestController
public class ArRestController {
	
	@Autowired
	private ArService arService;
	
	@PostMapping("/app")
	public ResponseEntity<String> createcitizenApp(@RequestBody CitizenApp app){
		Integer appId = arService.createApplicatiion(app);
		return appId>0?new ResponseEntity<>("App created with App Id : "+appId,HttpStatus.OK)
				:new ResponseEntity<>("Invalid Request",HttpStatus.BAD_REQUEST);
	}
}
