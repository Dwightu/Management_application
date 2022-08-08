package com.itsdehui.projectmanagement.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsdehui.dto.ChartData;
import com.itsdehui.dto.EmployeeProject;
import com.itsdehui.projectmanagement.dao.EmployeeRepository;
import com.itsdehui.projectmanagement.dao.ProjectRepository;
import com.itsdehui.projectmanagement.entities.Project;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException{
        Map<String,Object> map=new HashMap<>();

        List<Project> projects=proRepo.findAll();
        List<EmployeeProject> employees=empRepo.employeeProjects();
        List<ChartData> projectData=proRepo.getProjectStatus();

        //Lets convert projectData object into a json structure for use in js
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonString=objectMapper.writeValueAsString(projectData);
        String jsonString2=objectMapper.writeValueAsString(employees);
        // [["NOTSTARTED",1],["INPROGRESS",2],["COMPLETED",1]]

        model.addAttribute("projectStatusCnt", jsonString);
        model.addAttribute("employeeCnt",jsonString2);
        model.addAttribute("employeesListProjectsCnt", employees);
        model.addAttribute("projects", projects);
        return "main/home";
    }
}
