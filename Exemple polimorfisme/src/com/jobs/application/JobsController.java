package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository=new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// crea manager 
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManagerEmployee());
		repository.addMember(manager);
		
	}


	public void payAllEmployeers() {
		// paga todos 
		for (AbsStaffMember member : repository.getAllMembers()) {
			member.pay();
		}
	}

	public String getAllEmployees() {
		// imprime empleaods
		
		//return repository.getAllMembers().stream().map(member -> member.getName()).collect(Collectors.joining(", "));
		
		String response = "";
		for (AbsStaffMember member : repository.getAllMembers()) {
			if (response.equals("")) {
				response += member.toString();
			} else {
				response += "\n" + member.toString();
			}
			
		}
		
		return response;
	}

	public void createVolunteer(String string, String string2, String string3, String string4) throws Exception {
		// crea voluntario
		Volunteer volunteer = new Volunteer(string, string2, string3, string4);
		repository.addMember(volunteer);
	}
	
	
	
}
