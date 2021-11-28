package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("ReviewProposal")
public class ReviewProposalDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        boolean comments = new Random().nextBoolean();
        execution.setVariable("hasComments", comments);
        WorkflowLogger.info(LOGGER, "Review Proposal", comments ? "Advisor has comments" : "Advisor has no comments");
    }
}
