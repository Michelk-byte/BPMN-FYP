package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.entity.Project;
import org.fyp.service.ProjectService;
import org.fyp.util.WorkflowLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CheckAvailableProject")
public class CheckAvailableProjectDelegate extends BaseDelegate implements JavaDelegate {

    @Autowired
    ProjectService projectService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Project> projects = projectService.getAll();
        System.out.println("Projects are:");
        int index = 0;
        for (Project project : projects) {
            index++;
            System.out.println(String.format("Project %d: %s", index, project));
        }

        WorkflowLogger.info(LOGGER, "Check Available Projects", "Available projects printed in the console");
    }
}
