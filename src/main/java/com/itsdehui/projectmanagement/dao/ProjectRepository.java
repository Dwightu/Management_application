package com.itsdehui.projectmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.itsdehui.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long>{
    
}
