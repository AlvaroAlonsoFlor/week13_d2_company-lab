package com.codeclan.example.company;

import com.codeclan.example.company.models.Department;
import com.codeclan.example.company.models.Employee;
import com.codeclan.example.company.repositories.DepartmentRepository;
import com.codeclan.example.company.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyApplicationTests {

	Department department;
	Employee employee1;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Before
	public void before() {
		department = new Department("marketing");
		employee1 = new Employee("John", "Smith", 12132142, department);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void createDepartmentAndEmployee() {
		departmentRepository.save(department);
		employeeRepository.save(employee1);
	}




}
