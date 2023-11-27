package cphbusiness.noInPuts.camunda_process_engine.service;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final RuntimeService runtimeService;

    @Autowired
    public ProcessServiceImpl(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void startRestaurantApplication(Map<String, Object> form) {
        runtimeService.startProcessInstanceByKey("restaurant-application", form);
    }
}