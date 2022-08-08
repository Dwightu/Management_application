package com.itsdehui.projectmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.itsdehui.dto.EmployeeProject;
import com.itsdehui.projectmanagement.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    @Override
    public List<Employee> findAll();

    @Query(nativeQuery=true,value = "SELECT e.first_name as firstname,e.last_name as lastname,count(pe.employee_id) as projectcount FROM EMPLOYEE e left join PROJECT_EMPLOYEE  pe ON pe.employee_id=e.employee_id GROUP BY e.first_name,e.last_name ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();

    public Employee findByEmployeeId(long theId);


}
