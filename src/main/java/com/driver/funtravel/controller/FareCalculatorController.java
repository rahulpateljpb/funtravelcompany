package com.driver.funtravel.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.driver.funtravel.model.CheapestFareResponse;
import com.driver.funtravel.model.DriverDetails;
import com.driver.funtravel.model.FileInfoDetail;
import com.driver.funtravel.repository.DriverRepository;
import com.driver.funtravel.repository.SearchResultRepository;

@Controller
public class FareCalculatorController {

	@Autowired
	DriverRepository driverRepo;

	@Autowired
	SearchResultRepository searchResultRepo;

	@PostMapping(path = "/uploadCsv", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView uploadCsv(@RequestParam("file") MultipartFile file,
			@RequestParam("driverName") String driverName) {
		double maximum = Double.MAX_VALUE;
		ModelAndView model = new ModelAndView();
		CheapestFareResponse response = null;
		List<CheapestFareResponse> cheapestFareResponse = null;
		try {
			if (!file.isEmpty()) {
				String content = new String(file.getBytes());
				String[] str = content.split(",");
				FileInfoDetail fileInfo = new FileInfoDetail();
				fileInfo.setTotalDistance(Integer.parseInt(str[0]));
				fileInfo.setDistTravelUnit(Integer.parseInt(str[1]));
				fileInfo.setCostPerDistTraveled(Integer.parseInt(str[2]));
				System.out.println(fileInfo.toString());
				System.out.println(driverName);

				List<DriverDetails> drivers = driverRepo.findAll();
				for (DriverDetails driver : drivers) {
					double i = calculateFare(driver, fileInfo);
					if (i < maximum) {
						maximum = i;
					}
				}
				response = new CheapestFareResponse(maximum, fileInfo.getTotalDistance(), fileInfo.getDistTravelUnit(),
						fileInfo.getCostPerDistTraveled());
				cheapestFareResponse = searchResultRepo.findAll();
				searchResultRepo.save(response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addObject("searchList", cheapestFareResponse);
		model.setViewName("FareCalculation");

		return model;
	}

	private double calculateFare(DriverDetails driver, FileInfoDetail fileInfo) {

		if (driver.getBfDistance() >= fileInfo.getTotalDistance()) {
			return driver.getBaseFarePrice();
		} else {
			double diffDistance = fileInfo.getTotalDistance() - driver.getBfDistance();

			return driver.getBaseFarePrice()
					+ ((diffDistance * fileInfo.getCostPerDistTraveled()) / fileInfo.getDistTravelUnit());
		}
	}
}
