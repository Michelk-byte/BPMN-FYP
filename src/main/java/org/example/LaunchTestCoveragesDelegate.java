package org.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class LaunchTestCoveragesDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random rando = new Random();
        delegateExecution.setVariable("CodehasBugs", rando.nextBoolean());
    }
}
