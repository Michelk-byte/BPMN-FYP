package org.example.formgroupandapply;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.utils.CamundaConstants;
import org.example.utils.LoggerDelegate;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CheckExistenceProjectsDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String project1 = (String) delegateExecution.getVariable("project1");
        String project2 = (String) delegateExecution.getVariable("project2");
        int count = 0;

        for (ArrayList<String> project : CamundaConstants.projects){
            if (project.contains(project1)) {
                ++count;
            }
            if (project.contains(project2)) {
                ++count;
            }

        }

        delegateExecution.setVariable("projectsExist", count == 2);
    }
}
