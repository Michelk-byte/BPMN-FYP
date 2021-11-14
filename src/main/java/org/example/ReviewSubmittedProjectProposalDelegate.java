package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class ReviewSubmittedProjectProposalDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int committeeReviewal = (int) delegateExecution.getVariable("committeeReviewal");
        if (committeeReviewal > 5) {
            delegateExecution.setVariable("proposalMeetsRequirement", true);
        } else {
            delegateExecution.setVariable("proposalMeetsRequirement", false);
        }
    }
}
