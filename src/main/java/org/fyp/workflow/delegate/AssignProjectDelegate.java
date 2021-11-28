package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.entity.ApplicantGroup;
import org.fyp.entity.Project;
import org.fyp.service.ApplicantGroupService;
import org.fyp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AssignProject")
public class AssignProjectDelegate extends BaseDelegate implements JavaDelegate {
    @Autowired
    ProjectService projectService;

    @Autowired
    ApplicantGroupService groupService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<Project> unassignedProjects =  projectService.getUnAssignedProjects();
        Project project = unassignedProjects.get(0);

        ApplicantGroup group = groupService.getRandomUnassignedGroupByProjectId(project.getId());
        project.setGroupId(group.getGroupId());
        project.setAssigned(true);
        group.setAssigned(true);

        groupService.saveOrUpdate(group);
        projectService.saveOrUpdate(project);
    }
}
