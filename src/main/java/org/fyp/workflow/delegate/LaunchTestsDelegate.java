package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("LaunchTests")
public class LaunchTestsDelegate extends BaseDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        boolean randomChoice = new Random().nextBoolean();
        execution.setVariable("hasBugs", randomChoice);
        WorkflowLogger.info(LOGGER, "Launch Tests", randomChoice ? "There are bugs present" : "No bugs present");
    }
}
