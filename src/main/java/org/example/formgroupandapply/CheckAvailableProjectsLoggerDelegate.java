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


        LOGGER.info("\n\n  ..."
                + ", projectsAvailable= " + CamundaConstants.printArrayOfArray(CamundaConstants.projects)
                + " \n\n");
    }
}
