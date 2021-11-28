package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("InformAdvisor")
public class InformAdvisorDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        boolean randomChoice = new Random().nextBoolean();
        execution.setVariable("randomChoice", randomChoice);
        WorkflowLogger.info(LOGGER, "Inform Advisor", randomChoice ? "Advisor leaves it up to random" : "Advisor will pick a group");

    }
}
