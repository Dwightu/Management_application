package com.itsdehui.projectmanagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.itsdehui.projectmanagement.dao.EmployeeRepository;
import com.itsdehui.projectmanagement.dao.ProjectRepository;


@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	ProjectRepository projRepo;


	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
