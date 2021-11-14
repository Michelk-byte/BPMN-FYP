package org.example.callforproject;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.utils.CamundaConstants;

import java.util.ArrayList;

public class ValidateProjectDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String projectTemplate = (String) delegateExecution.getVariable("projectTemplate");
        String numberOfStudents = (String) delegateExecution.getVariable("numberOfStudents");
        String numberOfAppliedGroups = "0";

        ArrayList<String> project = new ArrayList<>();
        project.add(projectTemplate);
        project.add(numberOfStudents);
        project.add(numberOfAppliedGroups);

        CamundaConstants.projects.add(project);
    }
}
