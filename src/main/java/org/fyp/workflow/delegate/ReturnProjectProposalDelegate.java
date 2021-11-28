package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

@Service("ReturnProjectProposal")
public class ReturnProjectProposalDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        WorkflowLogger.info(LOGGER, "Return Project Proposal", "Project proposal returned since it does not meet requirements");
    }
}
