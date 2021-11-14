package org.example.projectexecution;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class LaunchTestCoveragesDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random randomBugs = new Random();
        delegateExecution.setVariable("CodehasBugs", randomBugs.nextBoolean());
    }
}
