package com.jayesh.his.ar.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jayesh.his.ar.binding.CitizenApp;
import com.jayesh.his.ar.entity.CitizenAppEntity;
import com.jayesh.his.ar.repo.CitizenAppRepo;
import com.jayesh.his.ar.service.ArService;

@Service
public class arServiceImpl implements ArService {

	@Autowired
	private CitizenAppRepo appRepo;
	@Override
	public Integer createApplicatiion(CitizenApp app) {
		String endPointurl="https://ssa-web-app.herokuapp.com/ssn/{ssn}";
		
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointurl, String.class, app.getSsn());
		String stateName = responseEntity.getBody();
		
		if("New Jersey".equals(stateName)) {
			
			CitizenAppEntity entity=new CitizenAppEntity();
			BeanUtils.copyProperties(app, entity);
			entity.setStateName(stateName);
			CitizenAppEntity save = appRepo.save(entity);
			return save.getAppId();
		}
		return 0;
	}

}
