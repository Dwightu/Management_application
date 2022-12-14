package com.itsdehui.projectmanagement.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.itsdehui.projectmanagement.dao.EmployeeRepository;
import com.itsdehui.projectmanagement.dao.ProjectRepository;
import com.itsdehui.projectmanagement.entities.Employee;
import com.itsdehui.projectmanagement.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayEmployees(Model model){
        List<Project> projects=proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject=new Project();
        List<Employee> employees=empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createPrject(Project project,@RequestParam List<Long> employees, Model model){
        // this should handle saving to the database...
        proRepo.save(project);
        
        // use a redirect to prevent duplicate submissions
        return "redirect:/projects/new";
    }

    @GetMapping("/update")
    public String displayProjectUpdateForm(Model model,@RequestParam("id") long theId){
        Project thePro=proRepo.findByProjectId(theId);
        List<Employee> employees=empRepo.findAll();
        model.addAttribute("allEmployees", employees);
        model.addAttribute("project",thePro);
        return "projects/new-project";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") long theId,Model model){
        Project thePro=proRepo.findByProjectId(theId);
        proRepo.delete(thePro);
        return "redirect:/projects";
    }
}
