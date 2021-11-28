package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDelegate {
    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected Object getFormField(DelegateExecution execution, String formField) {
        return execution.getVariable(formField);
    }
}
