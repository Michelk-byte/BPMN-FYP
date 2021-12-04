package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.Constants;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("GetApproval")
public class GetApprovalDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        boolean passed = new Random().nextBoolean();
        execution.setVariable(Constants.VAR_CODEAPPROVED, passed);
        WorkflowLogger.info(LOGGER, "Get Approval", passed ? "Project code approved" : "Project code not approved");
    }
}

