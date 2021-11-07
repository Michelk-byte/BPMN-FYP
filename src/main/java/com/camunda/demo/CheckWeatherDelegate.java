package com.camunda.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;

public class CheckWeatherDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random random = new Random();

        delegateExecution.setVariable("name","Michel Khoury");
        delegateExecution.setVariable("weatherOK",random.nextBoolean());



    }
}
