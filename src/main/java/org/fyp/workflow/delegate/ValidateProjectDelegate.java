package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.entity.Project;
import org.fyp.service.ProjectService;
import org.fyp.util.Constants;
import org.fyp.util.WorkflowLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ValidateProject")
public class ValidateProjectDelegate extends BaseDelegate implements JavaDelegate {

    @Autowired
    ProjectService projectService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        String projectTitle = (String) getFormField(execution, Constants.FORMFIELD_PROJECTTITLE);
        String projectDescription = (String) getFormField(execution, Constants.FORMFIELD_PROJECTDESCRIPTION);
        String projectObjectives = (String) getFormField(execution, Constants.FORMFIELD_PROJECTOBJECTIVES);
        String projectDeliverables = (String) getFormField(execution, Constants.FORMFIELD_PROJECTDELIVERABLES);
        String projectSupervisor = (String) getFormField(execution, Constants.FORMFIELD_SUPERVISOR);
        String projectCoSupervisor = (String) getFormField(execution, Constants.FORMFIELD_COSUPERVISORS);
        String projectPrerequisites = (String) getFormField(execution, Constants.FORMFIELD_PREREQUISITES);
        String projectOutcome = (String) getFormField(execution, Constants.FORMFIELD_PROJECTOUTCOME);
        long numberOfStudents = (long) getFormField(execution, Constants.FORMFIELD_NUMBEROFSTUDENTS);

        Project project = new Project(projectTitle, projectDescription, projectObjectives, projectDeliverables, projectSupervisor, projectCoSupervisor, projectPrerequisites, projectOutcome, numberOfStudents);

        projectService.saveOrUpdate(project);
        WorkflowLogger.info(LOGGER, "Validate Project", "Project validated by committee.");

    }
}
