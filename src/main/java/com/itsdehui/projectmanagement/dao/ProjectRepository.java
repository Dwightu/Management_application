package com.itsdehui.projectmanagement.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itsdehui.projectmanagement.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long>{
    @Override
    public List<Project> findAll();
}
