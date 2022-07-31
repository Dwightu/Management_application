package com.itsdehui.projectmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itsdehui.projectmanagement.dao.EmployeeRepository;
import com.itsdehui.projectmanagement.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository empRepo; 

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee=new Employee();
        model.addAttribute("employee", aEmployee);
        return "new-employee";
    }

    @PostMapping("/save")
    public String createPrject(Employee employee,Model model){
        // this should handle saving to the database...
        empRepo.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new";
    }

}
