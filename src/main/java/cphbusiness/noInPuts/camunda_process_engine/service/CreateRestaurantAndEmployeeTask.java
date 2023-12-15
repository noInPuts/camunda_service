package cphbusiness.noInPuts.camunda_process_engine.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurantAndEmployeeTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("CreateRestaurantAndEmployeeTask");
    }
}
