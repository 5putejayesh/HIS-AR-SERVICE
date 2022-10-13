package com.jayesh.his.ar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayesh.his.ar.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Integer> {

}
