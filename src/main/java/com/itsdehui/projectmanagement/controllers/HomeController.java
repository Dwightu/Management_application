package com.itsdehui.projectmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itsdehui.projectmanagement.dao.EmployeeRepository;
import com.itsdehui.projectmanagement.dao.ProjectRepository;
import com.itsdehui.projectmanagement.entities.Employee;
import com.itsdehui.projectmanagement.entities.Project;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects=proRepo.findAll();
        List<Employee> employees=empRepo.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("projects", projects);
        return "main/home";
    }
}
