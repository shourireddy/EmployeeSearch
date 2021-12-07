package com.employee.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchByName(@RequestParam("name") String name) {
		try {
			List<Map<String, Object>> empolyees = jdbcTemplate
					.queryForList("Select * from employees join phonenumbers on employees.id = phonenumbers.id  where firstname =?", new Object[] { name });

			List<Employee> employees_list = new ArrayList<>();

			for (Map row : empolyees) {
				Employee obj = new Employee();
				String fName = (String) row.get("firstname");
				String address = (String) row.get("address");
				String lastname = (String) row.get("lastname");
				String phone = (String) row.get("number");
				String work = (String) row.get("work");
				String home = (String) row.get("home");
				String salary = (String) row.get("salary");
			
				
				obj.setFname(fName);
				obj.setLname(lastname);
				obj.setAddress(address);
				obj.setPhone(phone);
				obj.setHome(home);
				obj.setWork(work);
				obj.setSalary(salary);
				
				employees_list.add(obj);
			}
			return new ResponseEntity<List<Employee>>(employees_list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

	}

	@Autowired
	JdbcTemplate jdbctemplate;
	@GetMapping("/searchByNumber")
	public ResponseEntity<List<Employee>> searchByNumber(@RequestParam("phone") String phone) {

		try {
			List<Map<String, Object>> empolyees = jdbctemplate.queryForList(
					"Select * from phonenumbers join employees on employees.id = phonenumbers.id  where number =? or home =? or work =? ",
					new Object[] { phone, phone, phone });

			List<Employee> employees_list = new ArrayList<>();

			for (Map row : empolyees) {
				Employee obj = new Employee();
				String fName = (String) row.get("firstname");
				String address = (String) row.get("address");
				String lastname = (String) row.get("lastname");
				String phone1 = (String) row.get("number");
				String work = (String) row.get("work");
				String home = (String) row.get("home");
				String salary = (String) row.get("salary");

				obj.setFname(fName);
				obj.setLname(lastname);
				obj.setAddress(address);
				obj.setPhone(phone1);
				obj.setHome(home);
				obj.setWork(work);
				obj.setSalary(salary);
				
				employees_list.add(obj);
			}
			return new ResponseEntity<List<Employee>>(employees_list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/*")
	public void error() {
		System.out.print("exception");
	}

}
