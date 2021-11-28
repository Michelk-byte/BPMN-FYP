package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

@Service("SubmitProjectDescription")
public class SubmitProjectDescriptionDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        WorkflowLogger.info(LOGGER, "Submit Project Description", "Project template filled and submitted by advisor.");
    }
}
