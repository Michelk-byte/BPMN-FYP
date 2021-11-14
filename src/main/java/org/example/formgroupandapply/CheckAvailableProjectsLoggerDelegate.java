package org.example.formgroupandapply;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.example.utils.CamundaConstants;
import org.example.utils.LoggerDelegate;

import java.util.List;
import java.util.logging.Logger;

public class CheckAvailableProjectsLoggerDelegate implements JavaDelegate {
    private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        StringBuilder projects = new StringBuilder();
        projects.append("[ ");
        for (List<String> l1 : CamundaConstants.projects) {
            projects.append("[ ");
            for (String n : l1) {
                projects.append(n).append(", ");
            }
            projects.append("] ");
        }
        projects.append("] ");

        LOGGER.info("\n\n  ... LoggerDelegate invoked by "
                + "processDefinitionId=" + delegateExecution.getProcessDefinitionId()
                + ", projects= " + projects
                + " \n\n");
    }
}
