package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	String description;
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		//TODO
		this.description=description;//guarda propiedad de voluntario
		
	}

	
	@Override
	public void pay() {
		//no hay pago para voluntario
	}

}
