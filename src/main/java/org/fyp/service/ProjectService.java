package org.fyp.service;

import org.fyp.entity.Project;
import org.fyp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAll() { return projectRepository.findAll() ;}

    public List<Project> getUnAssignedProjects() { return projectRepository.findByProjectAssignedFalse();}

    public Project getProjectById(int id) {
        return projectRepository.findById(id).get();
    }

    public void saveOrUpdate(Project person) {
        projectRepository.save(person);
    }

    public void delete(int id) {
        projectRepository.deleteById(id);
    }
}
