package com.itsdehui.projectmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsdehui.projectmanagement.dao.EmployeeRepository;

@Service
public class EmployeeService {
    // Field Injection
    @Autowired
    EmployeeRepository emRepo;

    // constructer Injection
    // public EmployeeService(EmployeeRepository emRepo) {
    //     super();
    //     this.emRepo = emRepo;
    // }

    // Set Injection
    // @Autowired
    // public void setEmRepo(EmployeeRepository emRepo) {
    //     this.emRepo = emRepo;
    // }

    
}
