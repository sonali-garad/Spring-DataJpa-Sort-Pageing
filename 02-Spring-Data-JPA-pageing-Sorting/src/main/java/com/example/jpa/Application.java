package com.example.jpa;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.jpa.Repository.EmployeeRepo;
import com.example.jpa.entity.Employee;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext cxt = 
		SpringApplication.run(Application.class, args);
		
		//Getting the implementation class of interface 
		EmployeeRepo empRepo = cxt.getBean(EmployeeRepo.class);
		
		Employee emp = cxt.getBean(Employee.class);
//		emp.setEmpid(101);
//		emp.setEmpName("Sonali");
//		emp.setEmpAddress("Pune");
//		emp.setEmpSalary(78000);
		//ADD MORE RECOREDS ...
		
		Saving info in the DB 
		//empRepo.save(emp);
		
//Sorting will be based on the Name 		
		Sort sort = Sort.by("empName").ascending();
		
		
		int pageno = 1; 
		//Pagination :- Divide multiple record in multiple pages(pageno,pagesize) 
		PageRequest page= PageRequest.of(pageno-1 ,3);
		
			//List<Employee> lemp =  empRepo.findAll(sort);
		
		Page<Employee> page1 = empRepo.findAll(page);
		List<Employee> emps = page1.getContent();
		
		for(Employee e : emps)
			{
				System.out.println(e);
			}	
		
	}

}
