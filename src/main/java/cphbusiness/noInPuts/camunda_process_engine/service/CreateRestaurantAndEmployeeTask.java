package cphbusiness.noInPuts.camunda_process_engine.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateRestaurantAndEmployeeTask implements JavaDelegate {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CreateRestaurantAndEmployeeTask(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = delegateExecution.getVariable("name").toString();
        String email = delegateExecution.getVariable("email").toString();
        String phone = delegateExecution.getVariable("phone").toString();
        rabbitTemplate.convertAndSend("", "createRestaurant", "{\"name\":\""+ name +"\", \"email\":\""+ email +"\", \"phone\":\""+ phone +"\"}");
        System.out.println("Sending a create restaurant request to the restaurant service");
    }
}
