package com.camunda.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AskTDogForHelp implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String question = (String) delegateExecution.getVariable("question");

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation("AskTDog")
                .setVariable("question", question)
                .correlate();
    }
}
