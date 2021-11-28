package org.fyp.service;

import org.fyp.entity.ApplicantGroup;
import org.fyp.entity.Project;
import org.fyp.repository.ApplicantGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ApplicantGroupService {

    @Autowired
    ApplicantGroupRepository applicantGroupRepository;

    public List<ApplicantGroup> getAll() {
        return applicantGroupRepository.findAll();
    }

    public void saveOrUpdate(ApplicantGroup person) {
        applicantGroupRepository.save(person);
    }

    public ApplicantGroup getRandomUnassignedGroupByProjectId(long projectId) {
        List<ApplicantGroup> groups = applicantGroupRepository.findByProjectId1AndAssignedTrue(projectId);
        if (groups.size() == 0) {
            groups = applicantGroupRepository.findByProjectId2AndAssignedTrue(projectId);
        }
        Random rand = new Random();
        ApplicantGroup chosenGroup = groups.get(rand.nextInt(groups.size()));
        return chosenGroup;
    }
}
