package com.itsdehui.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.itsdehui.projectmanagement.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    
}
