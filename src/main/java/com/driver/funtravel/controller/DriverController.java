package com.driver.funtravel.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.driver.funtravel.model.DriverDetails;
import com.driver.funtravel.repository.DriverRepository;

@Controller
public class DriverController {

	@Autowired
	DriverRepository driverRepo;
	
	@PostMapping("/addDriver")
	public ModelAndView addDriver(DriverDetails driver) {
		ModelAndView mv = new ModelAndView();
		driverRepo.save(driver);
		mv.addObject("driver", driver);
		mv.setViewName("RegisterSuccess");
		return mv;
	}

//	@GetMapping("/getDriver/{driverId}")
//	public DriverDetails addDriver(@PathVariable int driverId) {
//		Optional<DriverDetails> driver = driverRepo.findById(driverId);
//		if (driver.isPresent()) {
//			return driver.get();
//		}
//		return new DriverDetails();
//	}
//
//	@GetMapping("/getDrivers")
//	public List<DriverDetails> addDriver() {
//		return driverRepo.findAll();
//
//	}


	@PutMapping("/updateDriver")
	public DriverDetails updateDriver(@RequestBody DriverDetails driver) {
		driverRepo.save(driver);
		return driver;
	}

	@DeleteMapping("/deleteDriver/{driverId}")
	public String deleteDriver(@PathVariable int driverId) {
		Optional<DriverDetails> driver = driverRepo.findById(driverId);
		if (driver.isPresent()) {
			driverRepo.delete(driver.get());
			return "Deleted";
		}
		return "Driver not found";
	}

}
