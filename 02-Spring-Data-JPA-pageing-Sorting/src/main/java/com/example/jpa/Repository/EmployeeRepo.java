package com.example.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
	
}