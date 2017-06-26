package com.idle.worknine.entity;

import org.springframework.stereotype.Service;

@Service
public class Contact {

	private final String contactName= "Srinadh Biroji";
	
	private final String mobile = "+91 9700003882";
	
	private final String address = "Hitech City";
	
	private final Integer pin = 500081;

	public String getContactName() {
		return contactName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAddress() {
		return address;
	}

	public Integer getPin() {
		return pin;
	}
	
	
}
