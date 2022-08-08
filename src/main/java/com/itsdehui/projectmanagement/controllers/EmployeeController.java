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
import com.itsdehui.projectmanagement.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository empRepo; 


    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees=empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee=new Employee();
        model.addAttribute("employee", aEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createPrject(Employee employee,Model model){
        // this should handle saving to the database...
        empRepo.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(Model model,@RequestParam("id") long theId){
        
        Employee theEmp=empRepo.findByEmployeeId(theId);
        model.addAttribute("employee",theEmp);
        return "employees/new-employee";
    }
    @GetMapping("delete")
    public String deleteEmployee(@RequestParam("id") long theId,Model model){
        Employee theEmp=empRepo.findByEmployeeId(theId);
        empRepo.delete(theEmp);
        return "redirect:/employees";
    }

}
