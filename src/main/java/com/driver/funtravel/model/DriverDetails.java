package com.driver.funtravel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriverDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;

	private String dName;

	private String dSurname;

	private String dEmail;

	private String dVehicleType;

	private double baseFarePrice;

	private double bfDistance;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdSurname() {
		return dSurname;
	}

	public void setdSurname(String dSurname) {
		this.dSurname = dSurname;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getdVehicleType() {
		return dVehicleType;
	}

	public void setdVehicleType(String dVehicleType) {
		this.dVehicleType = dVehicleType;
	}

	public double getBaseFarePrice() {
		return baseFarePrice;
	}

	public void setBaseFarePrice(double baseFarePrice) {
		this.baseFarePrice = baseFarePrice;
	}

	public double getBfDistance() {
		return bfDistance;
	}

	public void setBfDistance(double bfDistance) {
		this.bfDistance = bfDistance;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", dName=" + dName + ", dSurname=" + dSurname + ", dEmail=" + dEmail
				+ ", dVehicleType=" + dVehicleType + ", baseFarePrice=" + baseFarePrice + ", bfDistance=" + bfDistance
				+ "]";
	}
}
