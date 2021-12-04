package org.fyp.repository;

import org.fyp.entity.ApplicantGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantGroupRepository extends JpaRepository<ApplicantGroup, Integer> {
    List<ApplicantGroup> findByProjectId2AndAssignedFalse(long projectId);

    List<ApplicantGroup> findByProjectId1AndAssignedFalse(long projectId);
}
