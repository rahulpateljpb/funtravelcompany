package com.driver.funtravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driver.funtravel.model.DriverDetails;

public interface DriverRepository extends JpaRepository<DriverDetails, Integer> {

}
