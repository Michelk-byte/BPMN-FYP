package org.example.formgroupandapply;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.utils.CamundaConstants;
import org.example.utils.LoggerDelegate;

import java.util.ArrayList;
import java.util.logging.Logger;

public class SaveProjectSelectionDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String project1 = (String) delegateExecution.getVariable("project1");
        String project2 = (String) delegateExecution.getVariable("project2");
        int groupNumber = (int) delegateExecution.getVariable("groupNumber");

        for (ArrayList<String> project : CamundaConstants.projects){
            if (project.contains(project1)) {
                int numberOfAssignedStudents = Integer.parseInt(project.get(2)) + 1;
                project.set(2, String.valueOf(numberOfAssignedStudents));
            }
            if (project.contains(project2)) {
                int numberOfAssignedStudents = Integer.parseInt(project.get(2)) + 1;
                project.set(2, String.valueOf(numberOfAssignedStudents));
            }
            LOGGER.info(project.toString());
        }
    }
}
