package org.example.allocateproject;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.utils.CamundaConstants;

import java.util.ArrayList;

public class CheckConflictsDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String project1 = (String) delegateExecution.getVariable("project1");
        String project2 = (String) delegateExecution.getVariable("project2");
        int projectAllocationHasConflicts = 0;

        for (ArrayList<String> project : CamundaConstants.projects){
            if (project.contains(project1)) {
                int numberOfAssignedGroups = Integer.parseInt(project.get(2));
                if (numberOfAssignedGroups > 1) {
                    ++projectAllocationHasConflicts;
                }
            }
            if (project.contains(project2)) {
                int numberOfAssignedGroups = Integer.parseInt(project.get(2));
                if (numberOfAssignedGroups > 1) {
                    ++projectAllocationHasConflicts;
                }
            }
        }

        delegateExecution.setVariable("projectAllocationHasConflicts", projectAllocationHasConflicts > 0);
    }
}

