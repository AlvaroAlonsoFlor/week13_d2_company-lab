package com.codeclan.example.company;

import com.codeclan.example.company.models.Department;
import com.codeclan.example.company.models.Employee;
import com.codeclan.example.company.models.Project;
import com.codeclan.example.company.repositories.DepartmentRepository;
import com.codeclan.example.company.repositories.EmployeeRepository;
import com.codeclan.example.company.repositories.ProjectRepository;
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
	Employee employee2;
	Project project1;
	Project project2;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
    ProjectRepository projectRepository;

	@Before
	public void before() {
		department = new Department("marketing");
		employee1 = new Employee("John", "Smith", 12132142, department);
		employee2 = new Employee("Sarah", "Smith", 12132132, department);
		project1 = new Project("Time Machine", 10);
		project2 = new Project("Sell stuff", 15);
	}

	@Test
	public void contextLoads() {
	}

	@Test
    public void createAll() {
        departmentRepository.save(department);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        projectRepository.save(project1);
        projectRepository.save(project2);

        project1.addEmployee(employee1);
        project2.addEmployee(employee1);
        project2.addEmployee(employee2);

        projectRepository.save(project1);
        projectRepository.save(project2);
    }




}
