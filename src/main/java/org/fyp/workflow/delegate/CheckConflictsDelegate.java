package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("CheckConflicts")
public class CheckConflictsDelegate extends BaseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        boolean projectAllocationHasConflicts = new Random().nextBoolean();
        execution.setVariable("projectAllocationHasConflicts", projectAllocationHasConflicts);
        WorkflowLogger.info(LOGGER, "Check Conflicts", projectAllocationHasConflicts ? "Oh oh project has conflicts!" : "No conflicts!!!");

    }
}
