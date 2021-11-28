package org.fyp.repository;


import org.fyp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByProjectAssignedFalse();
}
